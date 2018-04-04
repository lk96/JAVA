package IsrAndOsw;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDeno {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("file.txt");
		FileWriter fw=new FileWriter("file2.txt",true);
		char[] buffer=new char[2056];
		int c;
		while ((c=fr.read(buffer,0,buffer.length))!=-1) {
			String s=new String(buffer,0,c);
			System.out.println(s);
			fw.write(buffer,0,c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}
}
