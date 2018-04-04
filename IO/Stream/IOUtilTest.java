package stream;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	public static void main(String[] args) {
//		try {
//			IOUtil.copyFile(new File("demo//demo.txt"),new File("demo//demo2.txt"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
//		try {
//			IOUtil.copyFileByBuffer(new File("demo//demo.txt"),new File("demo//demo2.txt"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			long start=System.currentTimeMillis();
			IOUtil.copyFileByByte(new File("demo//demo.txt"),new File("demo//demo3.txt"));
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
