package proxymodel;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
//		long starttime=System.currentTimeMillis();
//		System.out.println("������ʼ��ʻ...");
		//ʵ�ֿ���
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("������ʻ��...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long endtime=System.currentTimeMillis();
//		System.out.println("������ʻ����...������ʻʱ��"+(endtime-starttime)+"����");
	}

}
