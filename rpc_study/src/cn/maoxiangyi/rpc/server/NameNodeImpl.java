package cn.maoxiangyi.rpc.server;

import cn.maoxiangyi.rpc.version.NameNode;

public class NameNodeImpl implements NameNode {
	@Override
	public String say(String message) {
		System.out.println("客户端请求消息：" + message);
		return "hello master...".equals(message) ? "hello salve!" : "hello!";
	}
}
