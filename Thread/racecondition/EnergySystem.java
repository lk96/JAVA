package racecondition;

/**
 * ���������ϵͳ
 * ��ѭ�����غ㶨��
 * ��������ƾ�մ�������ʧ��ֻ�ܴ�һ��ת�Ƶ���һ��
 * @author Administrator
 *
 */
public class EnergySystem {

	//��������
	private final double[] energyBoxs;
	private final Object lockObj=new Object();
	/**
	 * 
	 * @param n �������ӵ�����
	 * @param initialEnergy ÿ���������ӳ�ʼ���е�����ֵ
	 */
	public EnergySystem(int n,double initialEnergy){
		energyBoxs=new double[n];
		for (int i = 0; i < energyBoxs.length; i++) {
			energyBoxs[i]=initialEnergy;
		}
	}
	/**
	 * ������ת�ƣ���һ�����ӵ���һ������
	 * @param from ����Դ
	 * @param to �����յ�
	 * @param amount ����ֵ
	 */
	public void transfer(int from,int to,double amount){
		
		synchronized (lockObj) {

			//whileѭ������֤����������ʱ���񶼻ᱻ�����赲
			//�����Ǽ�������CPU��Դ
			
			while (energyBoxs[from]<amount) {
				try {
					//����������ʱ�����̷߳���wait set
					lockObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				System.out.print(Thread.currentThread().getName());
				energyBoxs[from]-=amount;
				System.out.printf("��%dת��%10.2f��λ������%d",from,amount,to);
				energyBoxs[to]+=amount;
				System.out.printf("�����ܺͣ�%10.2f%n",getTotalEneergies());
				//����������lockObj�����ϵȴ����߳�
				lockObj.notifyAll();
				
		}	
	}
	/**
	 * ��ȡ��������������ܺ�
	 */
	private double getTotalEneergies() {
		double sum=0;
		for (double amount : energyBoxs)
			sum+=amount;
		return sum;
	}
	public int getBoxAmount(){
		return energyBoxs.length;
	}
}
