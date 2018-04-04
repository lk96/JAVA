package singlemodel;

/*
 * ����ģʽsingleton
 * ��Щ������Ҫһ�����㹻��
 * ���ã���֤����Ӧ�ó�����ĳ��ʵ������ֻ��һ��
 * ���ͣ�����ģʽ������ģʽ
 */
		//����ģʽ
public class Singleton {
	// �����췽��˽�л����������ⲿֱ�Ӵ�������
	private Singleton() {

	}

	// �������Ψһʵ�� ,ʹ��private static����
	private static Singleton instance = new Singleton();

	// �ṩһ�����ڻ�ȡʵ���ķ����� ʹ��public static����
	public static synchronized Singleton  getInstance() {
		return instance;
	}
}
