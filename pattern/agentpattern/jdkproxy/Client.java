package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import proxymodel.Car;
import proxymodel.Moveable;

public class Client {

	public static void main(String[] args) {
		Car car=new Car();
		InvocationHandler h=new TimeHandler(car);
		Class<?> cls=car.getClass();
		/**
		 * loader 类加载器
		 * interfaces 实现接口
		 * h invocaHandler
		 */
		Moveable m=(Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();
	}

}
