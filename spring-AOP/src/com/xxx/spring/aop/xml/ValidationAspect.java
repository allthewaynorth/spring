package com.xxx.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class ValidationAspect {
	
	//不同包下还需要加入包名
	@Before("LoggingAspect.declareJointPointExpression()") //execution(* com.xxx.spring.aop.impl.*.*(..))
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("--validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
