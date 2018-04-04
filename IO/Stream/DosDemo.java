package stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	public static void main(String[] args) throws IOException{
		String file="demo/dos.dat";
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(5);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//����UTF-8����д��
		dos.writeUTF("�й�");
		//����UTF-16be����д��
		dos.writeChars("�й�");
		dos.close();
		IOUtil.printHex(file);
	}

}
