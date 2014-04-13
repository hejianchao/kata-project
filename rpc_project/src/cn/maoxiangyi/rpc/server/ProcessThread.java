package cn.maoxiangyi.rpc.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import cn.maoxiangyi.rpc.domain.Data;
import cn.maoxiangyi.rpc.version.NameNode;

/**
 * 当两个进程在进行远程通信时，彼此可以发送各种类型的数据。无论是何种类型的数据，都会以二进制序列的形式在网络上传送。
 * 发送方需要把这个Java对象转换为字节序列，才能在网络上传送；接收方则需要把字节序列再恢复为Java对象。
 * 　　把Java对象转换为字节序列的过程称为对象的序列化。 　　把字节序列恢复为Java对象的过程称为对象的反序列化。 　　对象的序列化主要有两种用途：
 * 　　1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中； 　　2） 在网络上传送对象的字节序列。.
 */
public class ProcessThread extends Thread {

	private NameNode nameNode;
	private Socket socket;

	public ProcessThread() {
	}

	public ProcessThread(NameNode nameNode, Socket socket) {
		this.nameNode = nameNode;
		this.socket = socket;
	}

	public void run() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					socket.getInputStream());
			Data data = (Data) objectInputStream.readObject();
			NameNodeHandler.doMethod(nameNode, data);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					socket.getOutputStream());
			objectOutputStream.writeObject(data);
			objectOutputStream.flush();
			objectOutputStream.close();
			objectInputStream.close();
		} catch (Exception e) {
			System.out.print("任务运行失败....");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.print("socket 关闭失败");
			}
		}
	}
}