package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 */
public class TCPServer {
	public static void main(String[] args) {
	try {
		//1.����һ����������Socket����SeverSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
		ServerSocket serverSocket=new ServerSocket(8889);
		Socket socket=null;
		//��¼�ͻ�������
		int count=0;
		System.out.println("***�����������������ȴ��ͻ�������***");
		//ѭ�������ȴ��ͻ��˵�����
		while (true) {
			//2.����accept()������ʼ�������ȴ��ͻ�������
			socket= serverSocket.accept();
			//����һ���µ��߳�
			ServerThread serverThread=new ServerThread(socket);
			//�����߳�
			serverThread.start();
			count++;//ͳ�ƿͻ��˵�����
			System.out.println("�ͻ��˵�����Ϊ��"+count);
			InetAddress address=socket.getInetAddress();
			System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
