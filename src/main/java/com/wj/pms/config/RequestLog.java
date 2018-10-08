package com.wj.pms.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-9 下午8:12
 */
@Aspect
@Component
public class RequestLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLog.class);

    // defined aop pointcut
    @Pointcut("execution(* com.wj.pms.controller.*.*(..))")
    public void controllerLog() {
    }

    // log all of controller
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getSignature().getDeclaringType() + ",method:" + joinPoint.getSignature().getName()
                + ",params:" + Arrays.asList(joinPoint.getArgs()));
    }

    // result of return
    @AfterReturning(pointcut = "controllerLog()", returning = "retVal")
    public void after(JoinPoint joinPoint, Object retVal) {
        LOGGER.info(JSONObject.toJSONString(retVal));
    }

}

