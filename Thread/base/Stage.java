package base;

/**
 * 
 * @author Administrator
 *
 */
public class Stage extends Thread {

		public void run(){
			System.out.println("隋唐演义");
			//等待大戏上演
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("大幕徐徐拉开");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("话说隋朝末年，隋军与农民起义军杀的昏天黑地...");
			ArmyRunable armyTakOfSuiDynasty=new ArmyRunable();
			ArmyRunable armyTakOfRevolt=new ArmyRunable();
			
			//使用Runnable接口创建线程
			Thread armyOfSuiDynasty=new Thread(armyTakOfSuiDynasty,"隋军");
			Thread armyOfRevolt=new Thread(armyTakOfRevolt,"农民起义军");
			
			//启动线程
			armyOfSuiDynasty.start();
			armyOfRevolt.start();
			
			//线程休眠
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("正当双方激战正酣，半路杀出个程咬金");
			Thread mrCheng=new KeyPersonThread();
			mrCheng.setName("程咬金");
			
			System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
			//停止线程的方法
			armyTakOfSuiDynasty.keepRunning=false;
			armyTakOfRevolt.keepRunning=false;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*
			 * 历史大戏留给关键人物
			 */
			mrCheng.start();
			try {
				mrCheng.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
			System.out.println("再见！");
		}
	public static void main(String[] args) {
		new Stage().start();
	}

}
