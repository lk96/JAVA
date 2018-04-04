package encode;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "�й�ABC";
		// ת�����ֽ�
		byte[] bytes = s.getBytes();// ת�����ֽ���������ĿĬ�ϵı���
		for (byte b : bytes) {
			// toHexString���ֽ�ת��������INT��ʮ�����Ʒ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		// GBK��������ռ,2���ֽڣ�Ӣ��ռ��1��
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes3 = s.getBytes("utf-8");
		// UTF-8��������ռ��3���ֽڣ�Ӣ��ռ��1���ֽ�
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java��˫�ֽڱ��� UTF-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		// UTF-16be��������ռ,2���ֽڣ�Ӣ��ռ��2��
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б�� �ַ�����Ҳ��Ҫ�����ֱ��뷽ʽ��������������
		 */
		String str1 = new String(bytes4);
		System.out.println(str1);
		String str2 = new String(bytes4, "utf-16be");
		System.out.println(str2);
		/*
		 * �ı��ļ������ֽ����� ���������������ֽ����� ������������Ļ�����ֱ�Ӵ����ı��ļ�����ô���ı��ļ�ֻ��ʶANSI����
		 * 
		 */
	}

}
