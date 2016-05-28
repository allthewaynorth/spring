package com.xxx.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	//Ҫ�����Ķ���
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target){
		this.target = target;
	}
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		
		//������������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//������������ͣ�����������Щ����
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//�����ô����������еķ���ʱ��Ӧ��ִ�еĴ���
		InvocationHandler h = new InvocationHandler(){
			/*
			 * proxy:���ڷ��ص��Ǹ���������һ������£���invoke�����ж���ʹ�øö���
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName = method.getName();
				//��־
				System.out.println("xxx->The method " + methodName + " begins with " + Arrays.asList(args));
				
				//ִ�з���
				Object result = null;
				try {
					//ǰ��֪ͨ
					result = method.invoke(target, args);
					//����֪ͨ,���Է��ʵ������ķ���ֵ
				} catch (Exception e) {
					e.printStackTrace();
					//�쳣֪ͨ,���Է��ʵ��������ֵ��쳣
				}
				//����֪ͨ,��Ϊ�������ܻ�����쳣,���Է��ʲ��������ķ���ֵ
				
				//��־
				System.out.println("xxx->The method " + methodName + " ends with " + result);
				return result;
		}};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}