package base;

/**
 * 
 * @author Administrator
 *
 */
public class Stage extends Thread {

		public void run(){
			System.out.println("��������");
			//�ȴ���Ϸ����
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("��Ļ��������");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("��˵�峯ĩ�꣬�����ũ�������ɱ�Ļ���ڵ�...");
			ArmyRunable armyTakOfSuiDynasty=new ArmyRunable();
			ArmyRunable armyTakOfRevolt=new ArmyRunable();
			
			//ʹ��Runnable�ӿڴ����߳�
			Thread armyOfSuiDynasty=new Thread(armyTakOfSuiDynasty,"���");
			Thread armyOfRevolt=new Thread(armyTakOfRevolt,"ũ�������");
			
			//�����߳�
			armyOfSuiDynasty.start();
			armyOfRevolt.start();
			
			//�߳�����
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("����˫����ս��������·ɱ������ҧ��");
			Thread mrCheng=new KeyPersonThread();
			mrCheng.setName("��ҧ��");
			
			System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
			//ֹͣ�̵߳ķ���
			armyTakOfSuiDynasty.keepRunning=false;
			armyTakOfRevolt.keepRunning=false;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*
			 * ��ʷ��Ϸ�����ؼ�����
			 */
			mrCheng.start();
			try {
				mrCheng.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ף�");
			System.out.println("�ټ���");
		}
	public static void main(String[] args) {
		new Stage().start();
	}

}
