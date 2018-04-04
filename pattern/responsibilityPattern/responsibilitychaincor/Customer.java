package responsibilitychaincor;

import java.util.Random;

import responsibilitychain.PriceHandler;
import responsibilitychain.PriceHandlerFactory;

/*
 * øÕªß«Î«Û’€ø€
 */
public class Customer {
	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	
	
	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		Random rand=new Random();
		for (int i = 1; i <=100; i++) {
			System.out.print(i+":");
			customer.requestDiscount(rand.nextFloat());
		}
		
		
	}
}
