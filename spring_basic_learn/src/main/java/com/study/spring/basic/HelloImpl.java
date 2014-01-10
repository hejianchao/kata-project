package com.study.spring.basic;

public class HelloImpl implements HelloAPI {
	public HelloImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public HelloImpl(String a) {
		System.out.println(a);
	}

	@Override
	public void sayHello() {
		System.out.println("你好，我是何健超。");
	}

}
