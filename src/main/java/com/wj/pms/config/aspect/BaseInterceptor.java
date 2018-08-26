package com.wj.pms.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component("baseInterceptor")
public class BaseInterceptor {
	
	protected static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

	protected boolean methodIsContainAnnotationName(JoinPoint pjp, String name) {
		Signature signature = pjp.getSignature();    
		MethodSignature methodSignature = (MethodSignature)signature;    
		Method targetMethod = methodSignature.getMethod();
		Annotation[] annotations = targetMethod.getAnnotations();
		for(int i = 0; i < annotations.length; i++){   
			Annotation annotation = annotations[i];
			if(annotation.annotationType().getName().contains(name))
				return true;
	    }
		return false;
	}
	
	protected boolean parameterIsContainAnnotationName(JoinPoint pjp, String name) {
		//TODO 
		return false;
	}
}
