package com.xxx.spring.aop.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {
	
	//��ͬ���»���Ҫ�������
	@Before("LoggingAspect.declareJointPointExpression()") //execution(* com.xxx.spring.aop.impl.*.*(..))
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("--validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
