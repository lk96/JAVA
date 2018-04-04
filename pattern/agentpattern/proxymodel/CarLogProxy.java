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
		System.out.println("������ʼ��ʻ...");
		m.move();
		long endtime=System.currentTimeMillis();
		System.out.println("������ʻ����...������ʻʱ��"+(endtime-starttime)+"����");
	}

}
