package factorymodel;
/**
 * 模拟客户端的实现
 * @author Administrator
 *工厂模式是一种极端情况的抽象工厂模式，而抽象工厂模式可以看成是工厂模式的推广
 *工厂模式用来创建一个产品的等级结构，而抽象工厂模式是用来创建多个产品的等级结构
 *工厂模式只有一个抽象产品类，而抽象工厂模式有多个抽象产品类
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
