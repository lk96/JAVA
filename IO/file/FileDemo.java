package File;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// �˽⹹�캯�������
		File file = new File("E:\\Java\\java");
		// System.out.println(file.exists());
		if (!file.exists())
			file.mkdir();
		else
			file.delete();
		// �ж��Ƿ���һ��Ŀ¼,�����Ŀ¼����true���������Ŀ¼����Ŀ¼�����ڷ���false
		System.out.println(file.isDirectory());
		// �ж��Ƿ���һ���ļ�
		System.out.println(file.isFile());

		// File file2=new File("E:\\Java�ռ�1.txt");
		File file2 = new File("E:\\Java", "�ռ�1.txt");
		if (!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			file2.delete();

		// ���õ�File�����API
		System.out.println(file);// file.tostring()������
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
