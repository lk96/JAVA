package responsibilitychain;
/**
 * �۸����ˣ�������ͻ��ۿ�����
 * @author Administrator
 *
 */
public abstract class PriceHandler {
	/*
	 * ֱ�Ӻ�̣����ڴ�������
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	/*
	 * �����ۿ�����
	 */
	public abstract void processDiscount(float discount);
	
	
}
