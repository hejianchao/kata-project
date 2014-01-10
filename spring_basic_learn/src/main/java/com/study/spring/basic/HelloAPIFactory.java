package com.study.spring.basic;

public class HelloAPIFactory {
	public static HelloAPI getHelloAPI(String str, int age){
		System.out.println("age:" + age);
		return new HelloImpl(str);
	}
}
