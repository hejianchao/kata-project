package com.hjc.impl;

import com.hjc.service.IService;

public class LocalService implements IService {

	@Override
	public String sayHello() {
		return "Hello Local!!";
	}

	@Override
	public String getScheme() {
		return "local";
	}

}