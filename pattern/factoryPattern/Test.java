package factorymodel;
/**
 * ģ��ͻ��˵�ʵ��
 * @author Administrator
 *����ģʽ��һ�ּ�������ĳ��󹤳�ģʽ�������󹤳�ģʽ���Կ����ǹ���ģʽ���ƹ�
 *����ģʽ��������һ����Ʒ�ĵȼ��ṹ�������󹤳�ģʽ���������������Ʒ�ĵȼ��ṹ
 *����ģʽֻ��һ�������Ʒ�࣬�����󹤳�ģʽ�ж�������Ʒ��
 */
public class Test {
	public static void main(String[] args) {
//		HairInterface left=new LeftHair();
//		left.draw();
//		HairFactory factory=new HairFactory();
//		HairInterface left=factory.getHair("left");
//		left.draw();
		
		
//		HairInterface left=factory.getHairByClass("factorymodel.LeftHair");
//		left.draw();
		
//		HairInterface hair=factory.getHairByClassKey("in");
//		hair.draw();
		PersonFactory factory=new MCFctory();
		Girl girl=factory.getGirl();
		girl.drawWomen();
		PersonFactory factory1=new HNFactory();
		Boy boy=factory1.getBoy();
		boy.drawMan();
	}
}
