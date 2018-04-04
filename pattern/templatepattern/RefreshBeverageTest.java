package com.pattern.template;

public class RefreshBeverageTest {

	
	public static void main(String[] args) {
		System.out.println("制备咖啡");
		RefreshBeverage b1=new Coffe();
		b1.prepareBeverageTemplate();
		System.out.println("咖啡好了！");
		System.out.println("================");
		System.out.println("制备茶");
		RefreshBeverage b2=new Tea();
		b2.prepareBeverageTemplate();
		System.out.println("茶好了！");
	}

}
