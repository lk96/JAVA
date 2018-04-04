package base;

/**
 * 军队线程 模拟作战双方的行为
 * 
 * @author Administrator
 *
 */
public class ArmyRunable implements Runnable {
		//volatile保证了线程可以正确的读取其他线程的值
		//可见性
	    volatile boolean keepRunning=true;

	@Override
	public void run() {
		while (keepRunning) {
			//发动5连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				//让出处理器时间
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}
	
	
}
