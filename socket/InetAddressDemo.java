package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		//��ȡ������InetAddressʵ��
		InetAddress address=InetAddress.getLocalHost();
		System.out.println("�������:"+address.getHostName());
		System.out.println("IP��ַ"+address.getHostAddress());
		byte[] bytes=address.getAddress();//��ȡ�ֽ�������ʽ��IP��ַ
		System.out.println("�ֽ�������ʽ��IP"+Arrays.toString(bytes));
		System.out.println(address);
		//���ݻ�������ȡInetAddressʵ��
//		InetAddress address2=InetAddress.getByName("PC");
		
		InetAddress address2=InetAddress.getByName("169.254.194.22");
		
		
		System.out.println("�������:"+address2.getHostName());
		System.out.println("IP��ַ"+address2.getHostAddress());
	
	}

}