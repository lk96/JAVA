package ticketsRunnable;

class MyThread implements Runnable {
	private int ticketsCount = 5;// һ�����Ż�Ʊ

	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--; // �������Ʊ��������һ��
			System.out.println(Thread.currentThread().getName() + "����һ��Ʊ��ʣ��Ʊ��Ϊ��" + ticketsCount);
		}
	}
}

public class ticketsRunnable {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		//���������߳�ģ��������Ʊ����
		Thread th1 = new Thread(mt, "����1");
		Thread th2 = new Thread(mt, "����2");
		Thread th3 = new Thread(mt, "����3");
		//�����߳�
		th1.start();
		th2.start();
		th3.start();
	}
	
}
