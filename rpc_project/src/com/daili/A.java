package com.daili;

import java.lang.reflect.Proxy;

public class A {

	public static void main(String[] args) {
		// 实例化目标对象
		UserService userService = new UserServiceImpl();

		// 实例化InvocationHandler
		MyInvocationHandler invocationHandler = new MyInvocationHandler(
				userService);

		// 根据目标对象生成代理对象proxy 实际是： class proxy$0 extends Proxy implements
		// UserService
		UserService proxy = (UserService) Proxy.newProxyInstance(Thread
				.currentThread().getContextClassLoader(), userService
				.getClass().getInterfaces(), invocationHandler);

		// 调用代理对象的方法
		proxy.add();
	}
}
