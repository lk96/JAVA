package Strategymodelimpl;

import Strategymodel.FlyingStragety;

public class FlyWithRocket implements FlyingStragety {

	

	@Override
	public void performFly() {
		System.out.println("用火箭在太空中遨游");
	}

}
