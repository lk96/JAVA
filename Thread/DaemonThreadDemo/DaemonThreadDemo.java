package DaemonThreadDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable{

	@Override
	public void run() {
		System.out.println("�����ػ��߳�"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�˳��ػ��߳�"+Thread.currentThread().getName());
	}

	private void writeToFile()  throws Exception{
		File filename=new File("daemon.txt");
		
			@SuppressWarnings("resource")
			OutputStream os=new FileOutputStream(filename,true);
			int count=0;
			while (count<999) {
					os.write(("\r\nword"+count).getBytes());
					System.out.println("�ػ��߳�"+Thread.currentThread().getName()+"���ļ���д����Word"+count++);
					Thread.sleep(1000);
		} 
	}
}
public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("��ȥ���߳�"+Thread.currentThread().getName());
		DaemonThread daemonThread=new DaemonThread();
		Thread thread=new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("�˳����߳�"+Thread.currentThread().getName());
	}

}
