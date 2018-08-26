package com.wj.pms.config.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @describe 不通过AOP打印日志，需要自己手动打印
 * @author YoungSmith
 * @date 2018年6月26日 下午3:03:57
 */
@Target(value={METHOD, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface NonAopLog {
	String value() default "";
}
