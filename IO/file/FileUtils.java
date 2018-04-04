package File;
//列出File的一些常用操作比如过滤、遍历等操作

import java.io.File;
import java.io.IOException;

/**
 * 列出指定目录下（包括其子目录）的所有文件
 * 
 * @author Administrator
 *
 */
public class FileUtils {
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录：" + dir + "不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}
		/*
		 * //list()方法用于列出当前目录的下的子目录和文件 String[]
		 * filenames=dir.list();//返回的是字符串数组,不包含子目录下的内容 for (String string :
		 * filenames) { System.out.println(dir+"\\"+string); }
		 */

		File[] files = dir.listFiles();// 返回的是直接子目录（文件）的抽象
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					// 递归
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}
}
