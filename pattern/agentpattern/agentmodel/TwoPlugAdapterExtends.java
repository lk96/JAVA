package agentmodel;
/*
 * ���ü̳з�ʽ�Ĳ���������
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {

	@Override
	public void powerWithThree() {
		System.out.println("�����̳�������");
		this.powerWithTwo();
	}
	
}
