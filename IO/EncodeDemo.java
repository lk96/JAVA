package encode;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "中国ABC";
		// 转换成字节
		byte[] bytes = s.getBytes();// 转换成字节序列是项目默认的编码
		for (byte b : bytes) {
			// toHexString把字节转换成以了INT以十六进制方式显示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		// GBK编码中文占,2个字节，英文占用1个
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes3 = s.getBytes("utf-8");
		// UTF-8编码中文占用3个字节，英文占用1个字节
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java是双字节编码 UTF-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		// UTF-16be编码中文占,2个字节，英文占用2个
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * 当你的字节序列是某种编码时，这个时候想把字节序列变成 字符串，也需要用这种编码方式，否则会出现乱码
		 */
		String str1 = new String(bytes4);
		System.out.println(str1);
		String str2 = new String(bytes4, "utf-16be");
		System.out.println(str2);
		/*
		 * 文本文件就是字节序列 可以是任意编码的字节序列 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ANSI编码
		 * 
		 */
	}

}
