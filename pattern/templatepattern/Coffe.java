package com.pattern.template;
/*
 * �������࣬�ṩ�˲����Ʊ��ľ���ʵ��
 */
public class Coffe extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("�����Ǻ�ţ��");
	}

	@Override
	protected void brew() {
		System.out.println("�÷�ˮ���ݿ���");
	}

}
