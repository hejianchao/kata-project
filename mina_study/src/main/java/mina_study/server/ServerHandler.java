package mina_study.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoHandlerAdapter {

	public void exceptionCaught(IoSession session, Throwable cause) {
		session.close(true);
		cause.printStackTrace();
	}

	public void messageReceived(IoSession session, Object msg) throws Exception {
		String msgStr = (String) msg;
		System.out.println("收到客户端发送的字符串：" + msgStr);
		session.write(msgStr);
	}
}