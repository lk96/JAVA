/**
 * 
 */
package stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 *
 */
public class FileOutDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//如果该文件不存在，则直接创建，如果存在，删除后创建
		//有ture如果存在，则添加内容
		FileOutputStream out=new FileOutputStream("demo/out.dat");
		out.write('A');//写出了A的低八位
		out.write('B');//写出了B的低八位
		int a=10;//write只能写八位，那么写一个整数需要写四次每次八位
		out.write(a>>>24);
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a>>>0);
		byte[] gbk="中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		IOUtil.printHex("demo/out.dat");
		
	}
	

}
