package com.study.spring.basic;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader()
				.getResource(""));
		System.out.println(Thread.currentThread().getContextClassLoader()
				.getResource("/"));
		System.out.println(Client.class.getResource("/"));
		System.out.println("-->" + ClassLoader.getSystemResource(""));
		ApplicationContext context = new ClassPathXmlApplicationContext("a.xml");
		HelloAPI helloAPI01 = context.getBean("HelloAPI", HelloAPI.class);
		HelloAPI helloAPI02 = context.getBean("aaa", HelloAPI.class);
		helloAPI01.sayHello();
		helloAPI02.sayHello();
		System.out.println(helloAPI01 == helloAPI02);
		System.out.println(Arrays.asList(context.getAliases("aaa")));
		System.out.println(context.getBean("HelloAPIFromFactory",HelloAPI.class));
		
		ListTest listTest = context.getBean("ListTest", ListTest.class);
		System.out.println(listTest);
		System.out.println(listTest.getaList().size());
	}

}
