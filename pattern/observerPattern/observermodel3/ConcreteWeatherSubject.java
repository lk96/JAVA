package observermodel3;

import java.util.Observable;
//����Ŀ��ľ���ʵ����
public class ConcreteWeatherSubject extends Observable {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//�������£�֪ͨ���й۲���
		//ע����֪֮ͨǰ����java�е�Observerģʽʱ��������仰������
		this.setChanged();
		//Ȼ������֪ͨ���Ʒ�ʽ
		this.notifyObservers(content);
		//����ʽ
		//this.notifyObservers();
	}
	
}
