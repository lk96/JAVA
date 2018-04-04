package com.pattern.template;
/*
 * �������࣬�ṩ���Ʊ���ľ���ʵ��
 */
public class Tea extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("��������");
	}

	@Override
	protected void brew() {
		System.out.println("��80�ȵ���ˮ���ݲ�Ҷ5����");
	}
	/*
	 * ����ͨ�����ǵ���ʽѡ����ع��Ӻ���
	 * @see com.pattern.template.RefreshBeverage#isCustomerWantsCondiments()
	 */
	@Override
	protected boolean isCustomerWantsCondiments(){
		return false;
	}
}
