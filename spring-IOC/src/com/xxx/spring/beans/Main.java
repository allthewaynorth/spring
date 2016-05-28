package com.xxx.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
	
//		����HelloWorld��һ������
//		HelloWorld helloWorld = new HelloWorld();
//		Ϊname���Ը�ֵ
//		helloWorld.setName("xxx");
	
		//1.����Spring��IOC��������:��������޲ι��췽��,����ֵ
		//ApplicationContext����IOC����
		//ClassPathXmlApplicationContext: ��ApplicationContext�ӿڵ�ʵ����.��ʵ�������·���¼��������ļ�.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.��IOC�����л�ȡBeanʵ��
		//����id��λ��IOC�����е�bean
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		//�������ͷ���IOC�����е�bean,��Ҫ��IOC�����б���ֻ����һ�������͵�bean.
		//HelloWorld helloWorld2 = ctx.getBean(HelloWorld.class);
		
		//3.����hello����
		helloWorld.hello();
		
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car)ctx.getBean("car2");
		System.out.println(car2);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
	}
}
