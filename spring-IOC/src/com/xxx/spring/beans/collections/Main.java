package com.xxx.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3);
		
		NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
		System.out.println(newPerson);
		
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getProperties());
		
		Person person = (Person) ctx.getBean("person4");
		System.out.println(person);
		
		Person person5 = (Person) ctx.getBean("person5");
		System.out.println(person5);
	}
	
}
