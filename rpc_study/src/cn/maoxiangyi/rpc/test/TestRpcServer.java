package cn.maoxiangyi.rpc.test;

import cn.maoxiangyi.rpc.RPC;
import cn.maoxiangyi.rpc.server.NameNodeImpl;

/**
 * 创建服务端
 */
public class TestRpcServer {

	public static void main(String[] args) throws Exception {
		RPC.getServer(new NameNodeImpl(), 8888, 200, "127.0.0.1");
	}

}