package Strategymodel;

import Strategymodelimpl.FlyNoWay;

public class BigYellow extends Duck {

	public BigYellow() {
		super();
		super.setFlyingStragety(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("������ܴ�ȫ��ƻ�");
	}

}
