package com.hjc;

import java.util.ServiceLoader;

import com.hjc.service.IService;

/**
 * 真实使用场景是：A模块声明了一个接口spi（如本案例中的com.hjc.service.IService），
 * B模块去具体实现（如本案例中的com.hjc.
 * impl.HDFSService，com.hjc.impl.LocalService，并且配置好META-INF信息，声明自己提供的实现类完整名称）
 * 然后B模块打成jar包，提供给A模块使用。A模块使用时，采用类似本案例中ServiceLoaderTest方式使用即可。
 * 
 */
public class ServiceLoaderTest {

	public static void main(String[] args) {
		// need to define related class full name in /META-INF/services/....
		// 注意：META-INF文件，直接放到src/main/resources即可！不要放到其他地方。maven打包时，会自动把META-INF打入jar包。
		ServiceLoader<IService> serviceLoader = ServiceLoader
				.load(IService.class);
		System.out.println(serviceLoader);
		for (IService service : serviceLoader) {
			System.out.println(service.getScheme() + "=" + service.sayHello());
		}
	}

}
