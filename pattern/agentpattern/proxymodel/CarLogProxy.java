package proxymodel;

public class CarLogProxy implements Moveable {
	
	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}
	private Moveable m;
	@Override
	public void move() {
		long starttime=System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		m.move();
		long endtime=System.currentTimeMillis();
		System.out.println("汽车行驶结束...汽车行驶时间"+(endtime-starttime)+"毫秒");
	}

}
