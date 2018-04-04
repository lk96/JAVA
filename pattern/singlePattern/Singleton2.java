package singlemodel;
/*
 * ����ģʽ
 * ���𣺶���ģʽ���ص��Ǽ�����ʱ�Ƚ�����������ʱ��ȡ������ٶȱȽϿ� �̰߳�ȫ
 * 	        ����ģʽ���ص��Ǽ�����ʱ�ȽϿ죬������ʱ��ȡ������ٶȱȽ����̲߳���ȫ
 */
public class Singleton2 {
	// �����췽��˽�л����������ⲿֱ�Ӵ�������
		private Singleton2() {

		}

		// �������Ψһʵ�� ,ʹ��private static����
		private static Singleton2 instance;
		// �ṩһ�����ڻ�ȡʵ���ķ����� ʹ��public static����
		public static  synchronized Singleton2 getInstance() {
			if (instance==null) {
				instance=new Singleton2();
			}
			return instance;
		}
}
