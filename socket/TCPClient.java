package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class TCPClient {
	public static void main(String[] args) {
		try {
			//1.�����ͻ���Socket��ָ�������ַ�Ͷ˿�
			Socket socket=new Socket("localhost",8889);
			//2.��ȡ��������������������Ϣ
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("�û�����admin2�����룺123");
			pw.flush();
			socket.shutdownOutput();
			//3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���ǿͻ��� �������˵��"+info);
			}
			//4.�ر���Դ
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
