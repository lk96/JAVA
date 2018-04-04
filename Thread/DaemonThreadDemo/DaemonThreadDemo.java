package DaemonThreadDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable{

	@Override
	public void run() {
		System.out.println("进入守护线程"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程"+Thread.currentThread().getName());
	}

	private void writeToFile()  throws Exception{
		File filename=new File("daemon.txt");
		
			@SuppressWarnings("resource")
			OutputStream os=new FileOutputStream(filename,true);
			int count=0;
			while (count<999) {
					os.write(("\r\nword"+count).getBytes());
					System.out.println("守护线程"+Thread.currentThread().getName()+"向文件中写入了Word"+count++);
					Thread.sleep(1000);
		} 
	}
}
public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("进去主线程"+Thread.currentThread().getName());
		DaemonThread daemonThread=new DaemonThread();
		Thread thread=new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("退出主线程"+Thread.currentThread().getName());
	}

}
