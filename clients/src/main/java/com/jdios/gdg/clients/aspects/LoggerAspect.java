package com.jdios.gdg.clients.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Aspect to manage general logs
 * @author jdotero
 *
 */
@Aspect
@Component
public class LoggerAspect {
	
	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    System.out.println( joinPoint.getClass() + " - " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}
}
