package responsibilitychain;

/*
 * ÕÛ¿Û³¬¹ı55%£¬¾Í¾Ü¾øÉêÇë
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount<=0.55) {
			System.out.format("%sÅú×¼ÁËÕÛ¿Û£º%.2f%n", this.getClass().getName(),discount);
		}else {
			System.out.format("%s¾Ü¾øÁËÕÛ¿Û£º%.2f%n", this.getClass().getName(),discount);
		}
	}

}
