package com.xxx.spring.aop.annotation;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//�����������Ϊһ�����棺��Ҫ�Ѹ�����뵽IOC������,������Ϊһ������
//����ʹ��orderע��ָ����������ȼ�,ֵԽС���ȼ�Խ��
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	//����һ������,���������������ʽ,һ���,�÷����в�����Ҫ���������Ĵ���
	//ʹ��PointCut�����������ʽ
	//���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ
	@Pointcut("execution(public int com.xxx.spring.aop.annotation.ArithmeticCalculator.*(int,int))")
	public void declareJointPointExpression(){}
	
	//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	//����֪ͨ:��Ŀ�귽��ִ�к�(�����Ƿ����쳣),ִ�е�֪ͨ.
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	//����֪ͨ:�ڷ�������������ִ�еĴ���
	//����֪ͨ���Է��ʵ������ķ���ֵ
	@AfterReturning(value="declareJointPointExpression()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	//�쳣֪ͨ:��Ŀ�귽�������쳣ʱ��ִ�еĴ���.
	//���Է��ʵ��쳣����;�ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	@AfterThrowing(value="declareJointPointExpression()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}
	
	//����֪ͨ:��ҪЯ��ProceedingJoinPoint���͵Ĳ���.
	//����֪ͨ�����ڶ�̬�����ȫ����: ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��.
	//�һ���֪ͨ�����з���ֵ,����ֵ��ΪĿ�귽���ķ���ֵ
	
	/*
 	@Around(value="execution(public int com.xxx.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			//ǰ��֪ͨ
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//ִ��Ŀ�귽��
			result = pjd.proceed();
			//����֪ͨ
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//����֪ͨ
		System.out.println("The method " + methodName + " ends");
		return result;
	}
	 */
	
}
