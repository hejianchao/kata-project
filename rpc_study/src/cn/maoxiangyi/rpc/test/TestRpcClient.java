package cn.maoxiangyi.rpc.test;

import cn.maoxiangyi.rpc.version.NameNode;
import cn.maoxiangyi.rpc.RPC;

/**
 * 创建客户端。RPC客户端使用的方便之处在此体现。 
 */
public class TestRpcClient {

	public static void main(String[] args) throws Exception {

		for (int i = 1; i > 0; i--) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						NameNode nameNode = RPC.getProxy(NameNode.class,
								"127.0.0.1", 8888);
						nameNode.say("我想做个代理!");
					} catch (Exception e) {

					}
				}
			}).start();

		}

	}

}