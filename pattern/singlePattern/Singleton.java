package singlemodel;

/*
 * 单例模式singleton
 * 有些对象需要一个就足够了
 * 作用：保证整个应用程序中某个实例有且只有一个
 * 类型：饿汉模式、懒汉模式
 */
		//饿汉模式
public class Singleton {
	// 将构造方法私有化，不允许外部直接创建对象
	private Singleton() {

	}

	// 创建类的唯一实例 ,使用private static修饰
	private static Singleton instance = new Singleton();

	// 提供一个用于获取实例的方法， 使用public static修饰
	public static synchronized Singleton  getInstance() {
		return instance;
	}
}
