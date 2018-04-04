package Strategymodel;

import Strategymodelimpl.FlyWithWin;

public class ReadheadDuck extends Duck {

	 public ReadheadDuck() {
		 super();
		 super.setFlyingStragety(new FlyWithWin());
	}
	@Override
	public void display() {
		System.out.println("我的脖子是红色的");
	}
}
