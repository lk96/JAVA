package responsibilitychain;

/*
 * ����С�鳤��������׼5%���ڵ��ۿ�
 */
public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount<=0.15) {
			System.out.format("%s��׼���ۿۣ�%.2f%n", this.getClass().getName(),discount);
		}else {
			successor.processDiscount(discount);
		}
	}

}