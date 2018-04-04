package File;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// 了解构造函数的情况
		File file = new File("E:\\Java\\java");
		// System.out.println(file.exists());
		if (!file.exists())
			file.mkdir();
		else
			file.delete();
		// 判断是否是一个目录,如果是目录返回true，如果不是目录或者目录不存在返回false
		System.out.println(file.isDirectory());
		// 判断是否是一个文件
		System.out.println(file.isFile());

		// File file2=new File("E:\\Java日记1.txt");
		File file2 = new File("E:\\Java", "日记1.txt");
		if (!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			file2.delete();

		// 常用的File对象的API
		System.out.println(file);// file.tostring()的内容
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
