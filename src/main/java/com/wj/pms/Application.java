package com.wj.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.wj.pms.mybatis.mapper")
@EnableAspectJAutoProxy
public class Application implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(10, new ThreadFactory() {
            private int threadIndex = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("spring-schedule-%d", threadIndex++));
            }
        });
    }

    @PreDestroy
    public void destory() {
        logger.info("Phantomjs Driver quit!");
    }
}

