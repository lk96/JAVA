package proxymodel;

public class CarTimeProxy implements Moveable {
	
	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}
	private Moveable m;
	@Override
	public void move() {
		System.out.println("��־��ʼ...");
		m.move();
		System.out.println("��־����...");
	}

}
