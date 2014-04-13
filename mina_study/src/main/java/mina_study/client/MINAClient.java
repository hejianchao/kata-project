package mina_study.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MINAClient {

	static Socket socket;

	public static void main(String[] args) {
		try {
			socket = new Socket(InetAddress.getLocalHost(), 29000);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "GBK"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream(), "GBK"));
			out.write("你好，mina，我是何健超");
			out.newLine();
			out.flush();
			System.out.println("服务器端接收到字符串并返回：" + in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
