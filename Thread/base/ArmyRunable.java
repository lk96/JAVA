package base;

/**
 * �����߳� ģ����ս˫������Ϊ
 * 
 * @author Administrator
 *
 */
public class ArmyRunable implements Runnable {
		//volatile��֤���߳̿�����ȷ�Ķ�ȡ�����̵߳�ֵ
		//�ɼ���
	    volatile boolean keepRunning=true;

	@Override
	public void run() {
		while (keepRunning) {
			//����5����
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]");
				//�ó�������ʱ��
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}
	
	
}
