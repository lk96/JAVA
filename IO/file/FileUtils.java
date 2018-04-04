package File;
//�г�File��һЩ���ò���������ˡ������Ȳ���

import java.io.File;
import java.io.IOException;

/**
 * �г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
 * 
 * @author Administrator
 *
 */
public class FileUtils {
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼��" + dir + "������");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "����Ŀ¼");
		}
		/*
		 * //list()���������г���ǰĿ¼���µ���Ŀ¼���ļ� String[]
		 * filenames=dir.list();//���ص����ַ�������,��������Ŀ¼�µ����� for (String string :
		 * filenames) { System.out.println(dir+"\\"+string); }
		 */

		File[] files = dir.listFiles();// ���ص���ֱ����Ŀ¼���ļ����ĳ���
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					// �ݹ�
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}
}
