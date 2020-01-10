package com.raboapp.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	 private Logger logger = LogManager.getLogger(this.getClass());
	 
	 @Pointcut("within(com.raboapp..*)")
	 public void commonJoinPointConfig(){}
	 
	@Before("commonJoinPointConfig()")
	public void before(JoinPoint joinPoint){
		logger.info(" Started Execution for ", joinPoint.getSignature().getDeclaringTypeName());
	}
	
	@AfterReturning(value="commonJoinPointConfig()", returning="result")
	public void afterRurning(JoinPoint joinPoint, ResponseEntity<Object> result){
		logger.info("End Execution for ", joinPoint, result.getStatusCode() + ": " +result.getStatusCodeValue());
	}
	
	@AfterThrowing(value="commonJoinPointConfig()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		logger.info("Failed Execution for ", joinPoint, ex.getMessage());
	}

	

}
