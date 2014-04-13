package mina_study.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MINAServer {

	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor();

		acceptor.setHandler(new ServerHandler());
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset
						.forName("GBK"))));

		try {
			acceptor.bind(new InetSocketAddress(29000));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}