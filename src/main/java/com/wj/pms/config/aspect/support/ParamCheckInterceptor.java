package com.wj.pms.config.aspect.support;

import com.wj.pms.common.Result;
import com.wj.pms.config.aspect.BaseInterceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @describe 参数校验控制
 * @author YoungSmith
 * @date 2018年7月12日 下午5:08:07
 */
@Aspect
@Component("paramCheckInterceptor")
public class ParamCheckInterceptor extends BaseInterceptor {
	
	@Pointcut("execution(public * com.wj.pms.controller.*.*(..))")
	public void myMethod() {
	};

	@Around("myMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		if(methodHasParamNullCheckerAnnotation(pjp)){
			Object[] args = pjp.getArgs();
			for (Object arg : args) {
				logger.info("start check param, the rule[IS NULL] ");
				try {
					ParamCheckHelper.checkParamNull(arg);
				} catch (NotExceptNullException e) {
					logger.error("check param is  has error, rule[IS NULL]. ", e);
					logger.info("check param " + arg.toString());
					return Result.fail(e);
				}
			}
		}
		return pjp.proceed();
	}

	private boolean methodHasParamNullCheckerAnnotation(JoinPoint pjp) {
		return methodIsContainAnnotationName(pjp, "ParamNullChecker");
	}

}