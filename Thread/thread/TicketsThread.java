package thread;

class MyThread extends Thread{
	private int ticketsCount=5;//һ�����Ż�Ʊ
	private String name;  //����Ҳ���̵߳�����
	public MyThread(String name ) {
		this.name=name;
	}
	@Override
	public void run() {
		while (ticketsCount>0) {
			ticketsCount--;   //�������Ʊ��������һ��
			System.out.println(name+"����һ��Ʊ��ʣ��Ʊ��Ϊ��"+ticketsCount);
		}
	}
}

public class TicketsThread  {

	public static void main(String[] args) {
		//���������̣߳�ģ������������Ʊ
		MyThread mt1=new MyThread("����1");
		MyThread mt2=new MyThread("����2");
		MyThread mt3=new MyThread("����3");
		//���������߳� ��ʼ��Ʊ
		mt1.start();
		mt2.start();
		mt3.start();
	}

}
