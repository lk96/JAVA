package IsrAndOsw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws Exception{
		FileInputStream in=new FileInputStream("file.txt");
		InputStreamReader isr=new InputStreamReader(in);//��ĿĬ�ϱ���,д�ļ��������
		FileOutputStream out=new FileOutputStream("file1.txt");
		OutputStreamWriter osw=new OutputStreamWriter(out,"gbk");
//		int c;
//		while( (c=isr.read())!=-1) {
//			System.out.print((char)c);
//		}
		char[] buffer=new char[8*1024];
		int c;
		//������ȡ������buffer����ַ������У��ӵ�0��λ�ÿ�ʼ���ã�����buffer.length��
		while ((c=isr.read(buffer,0,buffer.length))!=-1) {
			String s=new String(buffer,0,c);
			System.out.print(s);
			osw.write(buffer, 0, c);
			osw.flush();
		}
		isr.close();
		osw.close();
	}
	
}
