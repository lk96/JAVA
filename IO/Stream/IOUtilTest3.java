package stream;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		try {
			IOUtil.copyFile(new File("demo\\demo.txt"), new File("demo\\demo1.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
