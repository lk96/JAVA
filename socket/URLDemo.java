package socket;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args)  {
		try {
			//����һ��URLʵ��
			URL baidu=new URL("http://www.baidu.com");
			//?�����ʾ����#�����ʾê��
			URL url=new URL(baidu,"/index.html?username=tom#test");
			System.out.println("Э��:"+url.getProtocol());
			System.out.println("����:"+url.getHost());
			//���δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱgetPort()��������ֵΪ-1
			System.out.println("�˿ڣ�"+url.getPort());
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("���·����"+url.getRef());
			System.out.println("��ѯ�ַ�����"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
