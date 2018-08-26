package com.wj.pms.config.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @describe 
 * <pre>参数校验，校验参数不为null 或 空串</pre>
 * 被该注解注释的参数，如：</br>
 * public void test(@ParamChecker String val)</br>
 * 如果val 为null 或 空串 抛出   NO_EXPECTED_NULL("900004","不期望的NULL")</br>
 * public void test1(@ParamChecker Map<String, Object> map)</br>
 * map的任何value为null 或者 空串 都会 抛出    NO_EXPECTED_NULL("900004","不期望的NULL")</br>
 * </br>
 * @author YoungSmith
 * @date 2018年6月26日 下午3:03:57
 */
@Target(value={METHOD})
@Retention(RUNTIME)
@Documented
public @interface ParamNullChecker{
	String value() default "";
}
