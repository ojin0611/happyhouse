package com.ssafy.happyhouse.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.ssafy.happyhouse.model..*.*(..))")
	public void loggin(JoinPoint jp) {
		System.out.println("something");
		logger.info("메서드 선언부 : {} 전달 파라미터 : {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
	
	/*
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }

    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        logger.info("=====================AspectJ TEST  : Before Logging Start=====================");
        logger.info("=====================AspectJ TEST  : Before Logging End=====================");
    }	
    */
}
