package com.pattern.template;

public class RefreshBeverageTest {

	
	public static void main(String[] args) {
		System.out.println("�Ʊ�����");
		RefreshBeverage b1=new Coffe();
		b1.prepareBeverageTemplate();
		System.out.println("���Ⱥ��ˣ�");
		System.out.println("================");
		System.out.println("�Ʊ���");
		RefreshBeverage b2=new Tea();
		b2.prepareBeverageTemplate();
		System.out.println("����ˣ�");
	}

}
