package com.wj.pms.config.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;
/**
 * Guava EventBus Bean配置
 * @author YoungSmith
 * @date 2018年8月8日 下午2:51:37
 */
@Configuration("eventBusConfig")
public class EventBusConfig {
    @Bean("eventBus")
    public EventBus eventBus() {
        return new EventBus();
    }
}