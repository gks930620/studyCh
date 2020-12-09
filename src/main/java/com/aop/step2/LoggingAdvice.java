package com.aop.step2;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice {

	// private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void parameterCheck(JoinPoint joinPoint) {
		Class clazz = joinPoint.getTarget().getClass();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		
		Logger logger = LoggerFactory.getLogger(clazz);
		
		Object[] args = joinPoint.getArgs();
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------------");
		sb.append("\n " + className +" : " + methodName );
		int cnt = 1;
		for(Object obj : args) {
			sb.append("\n args" + cnt++ + " : " + ToStringBuilder.reflectionToString(obj));
		}				
		sb.append("\n-----------------------------------------");
		logger.debug(sb.toString());
	}
	
}
