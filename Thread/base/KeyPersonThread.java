package base;

public class KeyPersonThread extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName()+"��ʼս���ˣ�");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"��ͻ��ɱ���������...");
		}
		
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}
}
