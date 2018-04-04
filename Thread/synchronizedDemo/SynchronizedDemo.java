package synchronizedDemo;

public class SynchronizedDemo {
//�������
	private boolean ready=false;
	private int result=0;
	private int number=1;
	//д����
	public void write(){
		ready=true;
		number=2;
	}
	public void read(){
		if (ready) {
			result=number*3;
		}
		System.out.println("result��ֵΪ��"+result);
	}
	//�ڲ��߳���
	private class ReadWriteThread extends Thread{
		//���ݹ��췽���д����flag������ȷ���߳�ִ�ж���������д����
		private boolean flag;
		public ReadWriteThread(boolean flag){
			this.flag=flag;
		}
		@Override
		public void run() {
			if (flag) {
				//���췽���д���true��ִ�в���
				write();
			}else {
				//���췽���д���false��ִ�в���
				read();
			}
		}
	}
	public static void main(String[] args) {
		
		SynchronizedDemo synDemo=new SynchronizedDemo();
		//�����߳�ִ��д����
		synDemo.new ReadWriteThread(true).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�����߳�ִ�ж�����
		synDemo.new ReadWriteThread(false).start();
	}
}
