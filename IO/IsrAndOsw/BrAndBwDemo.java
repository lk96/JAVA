package IsrAndOsw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BrAndBwDemo {
	public static void main(String[] args) throws IOException {
		//���ļ����ж�д����
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file3.txt")));
		PrintWriter pw=new PrintWriter("file4.txt");
		String line;
		while ((line=br.readLine())!=null) {
			System.out.println(line);//һ�ζ�һ�У�������ʶ����
			/*bw.write(line);
			//����д�����в���
			bw.newLine();//���в���
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		pw.close();
//		bw.close();
	}
}
