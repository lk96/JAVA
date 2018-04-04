package singlemodel;
/*
 * 懒汉模式
 * 区别：饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快 线程安全
 * 	        懒汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢线程不安全
 */
public class Singleton2 {
	// 将构造方法私有化，不允许外部直接创建对象
		private Singleton2() {

		}

		// 创建类的唯一实例 ,使用private static修饰
		private static Singleton2 instance;
		// 提供一个用于获取实例的方法， 使用public static修饰
		public static  synchronized Singleton2 getInstance() {
			if (instance==null) {
				instance=new Singleton2();
			}
			return instance;
		}
}
