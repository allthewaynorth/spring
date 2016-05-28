package com.xxx.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xxx.spring.beans.annotation.TestObject;

@Repository //默认的value可省略
public class UserRepositoryImpl implements UserRepository{

	@Autowired(required=false)
	private TestObject testObject;
	
	@Override
	public void save() {
		System.out.println("UserRepository Save...");
		System.out.println(testObject);
	}

}
