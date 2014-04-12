package com.study.spring.bean_life_cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"bean_life_cycle.xml");
		((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
		LifeCycleBean bean1 = ctx.getBean("lifeCycleBean", LifeCycleBean.class);
		System.out.println("***********" + bean1 + "   " + bean1.getStr());
	}

}
