package com.wj.pms.common.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class NidsHttpMessageParser {
    public FullHttpRequest parseRawHttpRequest(InputStream is) throws IOException {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(
                new HttpRequestDecoder(),
                new HttpObjectAggregator(100 * 1024 * 1024));
        try {
            embeddedChannel.writeInbound(Unpooled.wrappedBuffer(IOUtils.toByteArray(is)));
            embeddedChannel.finish();
            return (FullHttpRequest) embeddedChannel.readInbound();
        } finally {
            embeddedChannel.finishAndReleaseAll();
        }
    }

    public FullHttpResponse parseRawHttpResponse(InputStream is) throws IOException {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(
                new HttpResponseDecoder(),
                new HttpObjectAggregator(100 * 1024 * 1024));
        embeddedChannel.writeInbound(Unpooled.wrappedBuffer(IOUtils.toByteArray(is)));
        try {
            embeddedChannel.close();
            return (FullHttpResponse) embeddedChannel.readInbound();
        } finally {
            embeddedChannel.finishAndReleaseAll();
        }
    }
}

