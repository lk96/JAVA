package ticketsRunnable;

class MyThread implements Runnable {
	private int ticketsCount = 5;// 一共五张火车票

	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--; // 如果还有票，就卖掉一张
			System.out.println(Thread.currentThread().getName() + "卖了一张票，剩余票数为：" + ticketsCount);
		}
	}
}

public class ticketsRunnable {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		//创建三个线程模拟三个售票窗口
		Thread th1 = new Thread(mt, "窗口1");
		Thread th2 = new Thread(mt, "窗口2");
		Thread th3 = new Thread(mt, "窗口3");
		//启动线程
		th1.start();
		th2.start();
		th3.start();
	}
	
}
