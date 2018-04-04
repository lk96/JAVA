package proxymodel;

public class Client {
	/**
	 * ≤‚ ‘¿‡
	 * @param args
	 */
	public static void main(String[] args) {
//		Car car=new Car();
//		CarTimeProxy ctp=new CarTimeProxy(car);
//		CarLogProxy clp=new CarLogProxy(ctp);
//		clp.move();
		
		
		Car car=new Car();
		CarLogProxy clp=new CarLogProxy(car);
		CarTimeProxy ctp=new CarTimeProxy(clp);
		ctp.move();
		
	}

}
