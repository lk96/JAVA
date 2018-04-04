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
		//对文件进行读写操作
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file3.txt")));
		PrintWriter pw=new PrintWriter("file4.txt");
		String line;
		while ((line=br.readLine())!=null) {
			System.out.println(line);//一次读一行，并不能识别换行
			/*bw.write(line);
			//单独写出换行操作
			bw.newLine();//换行操作
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		pw.close();
//		bw.close();
	}
}
