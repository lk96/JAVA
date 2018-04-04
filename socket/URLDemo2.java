package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * ʹ��URL��ȡҳ������
 */
public class URLDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//����һ��URLʵ��
			URL url=new URL("http://www.baidu.com");
			//ͨ��URL��openStream������ȡURL��������ʾ����Դ���ֽ�������
			InputStream is=url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			//Ϊ�ַ�����ӻ���
			BufferedReader br=new BufferedReader(isr);
			//��ȡ����
			String data=br.readLine();
			while(data!=null){//ѭ����ȡ����
				System.out.println(data);//�������
				data=br.readLine();
			}
			br.close();
			isr.close();
			is.close();
		} catch (Exception e) {
				e.printStackTrace();
		} 
	}

}
