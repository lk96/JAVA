package factorymodel;

/**
 * 右偏分发型
 */
public class RightHair implements HairInterface {
	/**
	 * 画了一个左偏分发型
	 */
	@Override
	public void draw() {
		System.out.println("---画了一个右偏分发型---");
	}

}
