package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ObjectSeriaDemo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("demo/obj1.dat"));
////		Foo2 foo2=new Foo2();
//		Bar2 bar2=new Bar2();
//		oos.writeObject(bar2);
//		oos.flush();
//		oos.close();
		//�����л��Ƿ�ݹ���ø��๹�캯��
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("demo/obj1.dat"));
//		Foo2 foo2=(Foo2) ois.readObject();
		Bar2 bar2=(Bar2) ois.readObject();
		System.out.println(bar2);
		ois.close();
		/**
		 * �����������з����л�����ʱ��
		 * �������û��ʵ�����л��ӿ�
		 * ��ô�丸��Ĺ��캯���ᱻ����
		 */
	}
}
/**
 * һ����ʵ�������л��ӿڣ���ô�����඼���Խ������л�
 * @author Administrator
 *
 */
class Foo implements Serializable{
	public Foo(){
		System.out.println("foo...");
	}
}
class Foo1 extends Foo{
	public Foo1(){
		System.out.println("foo1...");
	}
}
class Foo2 extends Foo1{
		public Foo2(){
			System.out.println("foo2...");
		}
}
class Bar{
	public Bar(){
		System.out.println("bar...");
	}
}
class Bar1 extends Bar implements Serializable{
	public Bar1(){
		System.out.println("bar1...");
	}
}
class Bar2 extends Bar1{
	public Bar2(){
		System.out.println("bar2...");
	}
}
