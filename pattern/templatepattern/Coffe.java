package com.pattern.template;
/*
 * 具体子类，提供了擦费制备的具体实现
 */
public class Coffe extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("加入糖和牛奶");
	}

	@Override
	protected void brew() {
		System.out.println("用沸水冲泡咖啡");
	}

}
