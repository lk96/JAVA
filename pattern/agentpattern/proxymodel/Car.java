package proxymodel;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
//		long starttime=System.currentTimeMillis();
//		System.out.println("汽车开始行驶...");
		//实现开车
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车行驶中...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long endtime=System.currentTimeMillis();
//		System.out.println("汽车行驶结束...汽车行驶时间"+(endtime-starttime)+"毫秒");
	}

}
