package com.hjc.impl;

import com.hjc.service.IService;

public class HDFSService implements IService {

	@Override
	public String sayHello() {
		return "Hello HDFS!!";
	}

	@Override
	public String getScheme() {
		return "hdfs";
	}
}
