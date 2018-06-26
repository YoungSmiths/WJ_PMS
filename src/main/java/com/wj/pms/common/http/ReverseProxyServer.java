package com.wj.pms.common.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSource;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReverseProxyServer {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ReverseProxyServer.class);
    private final int port;
    private final HttpProxyServer proxy;
    private final String target;

    public interface ProxyFilter {
        void proxyToClientResponse(FullHttpRequest request, FullHttpResponse response);
    }

    public class HttpFiltersSourceImpl implements HttpFiltersSource {
        private final ProxyFilter proxyFilter;
        public HttpFiltersSourceImpl(ProxyFilter filter) {
            this.proxyFilter = filter;
        }
        @Override
        public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
            return new HttpFiltersAdapter(originalRequest) {
                @Override
                public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                    if (httpObject instanceof FullHttpRequest) {
                        FullHttpRequest request = (FullHttpRequest) httpObject;
                        request.headers().set("Host", target);
                        request.setUri("http://" + target + request.getUri());
                        LOGGER.debug("Got modified request={}", request);
                    }
                    return null;
                }

                @Override
                public HttpObject proxyToClientResponse(HttpObject httpObject) {
                    if ((proxyFilter != null) && (httpObject instanceof FullHttpResponse)) {
                        FullHttpResponse response = (FullHttpResponse) httpObject;
                        try {
                            proxyFilter.proxyToClientResponse((FullHttpRequest) this.originalRequest, response);
                        } catch (Exception e) {
                            LOGGER.error("Filter request={} and response={} failed.", this.originalRequest, response, e);
                        }
                    }
                    return httpObject;
                }
            };
        }

        @Override
        public int getMaximumRequestBufferSizeInBytes() {
            return 10 * 1024 * 1024;
        }

        @Override
        public int getMaximumResponseBufferSizeInBytes() {
            return 50 * 1024 * 1024;
        }
    }

    public ReverseProxyServer(int port, String target, ProxyFilter filter) {
        this.port = port;
        this.target = target;
        proxy = DefaultHttpProxyServer.bootstrap()
                .withPort(port)
                .withTransparent(true)
                .withFiltersSource(new HttpFiltersSourceImpl(filter))
                .start();
    }

    public ReverseProxyServer(int port, String target, HttpFiltersSource filtersSource) {
        this.port = port;
        this.target = target;
        proxy = DefaultHttpProxyServer.bootstrap()
                .withPort(port)
                .withTransparent(true)
                .withFiltersSource(filtersSource)
                .start();
    }

    public ReverseProxyServer stop() {
        proxy.stop();
        return this;
    }

    @Override
    public String toString() {
        return String.format("ReverseProxyServer(port=%d, target=%s)", port, target);
    }
}

