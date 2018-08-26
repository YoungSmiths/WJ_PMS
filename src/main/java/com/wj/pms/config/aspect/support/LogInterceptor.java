package com.wj.pms.config.aspect.support;

import com.alibaba.fastjson.JSONObject;
import com.wj.pms.common.Result;
import com.wj.pms.common.enums.BaseResponseCodeEnum;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.config.aspect.BaseInterceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @describe 日志打印控制
 * @author YoungSmith
 * @date 2018年6月14日 下午2:14:06
 */
@Aspect
@Component("logInterceptor")
public class LogInterceptor extends BaseInterceptor {
	
	private static final Boolean isLogPretty = false;
	
	@Pointcut("execution(public * com.paic.biz.*.controller.*.*(..))")
	public void myMethod() {
	};

	/**
	 * 前置通知：在某连接点之前执行的通知，但这个通知不能阻止连接点前的执行
	 * 
	 * @param jp
	 *            连接点：程序执行过程中的某一行为
	 */
	@Before("myMethod()")
	public void before(JoinPoint jp) {
		
		String method = jp.getTarget().getClass().getName() + "." + jp.getSignature().getName();
		StringBuilder message = new StringBuilder(method + "() started.");
		logger.info(message.toString());
		
		if(!methodHasNonAopLogAnnotation(jp)){
			Object[] args = jp.getArgs();
			StringBuilder logStr = new StringBuilder(method + "'s param is [");
			for (Object arg : args) {
				try {
					logStr.append(JSONObject.toJSONString(arg, isLogPretty) + ",");
				} catch (Exception e) {
					// do nothing
				}
			}
			logStr.deleteCharAt(logStr.length() - 1);
			logStr.append("]");
			logger.info(logStr.toString());
		}
	}

	@After("myMethod()")
	public void after(JoinPoint jp) {
		String logStr = jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " finished.";
		logger.info(logStr);
	} 

	/**
	 * 环绕通知：包围一个连接点的通知，可以在方法的调用前后完成自定义的行为，也可以选择不执行。
	 * 类似web中Servlet规范中Filter的doFilter方法。
	 * 
	 * @param pjp
	 *            当前进程中的连接点
	 * @return
	 */
	@Around("myMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object result = null;
		String logStr = pjp.getTarget().getClass() + "." + pjp.getSignature().getName();
		try {
			result = pjp.proceed();
		} catch (BaseException e) {
			logger.error(logStr + " has Error. The Error Message is：", e);
			return Result.fail(e);
		} catch (Exception e) {
			logger.error(logStr + " has Error. The Error Message is：", e);
			return Result.fail(BaseResponseCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), null);
		}
		if(!methodHasNonAopLogAnnotation(pjp)){
			logger.info(logStr + "'s result is:  " + JSONObject.toJSONString(result));
		}
		logger.info(logStr + " Execution Time is：" + (System.currentTimeMillis() - time)/1000.00d + "s");
		return result;
	}
	
	private boolean methodHasNonAopLogAnnotation(JoinPoint pjp) {
		return methodIsContainAnnotationName(pjp, "NonAopLog");
	}
}