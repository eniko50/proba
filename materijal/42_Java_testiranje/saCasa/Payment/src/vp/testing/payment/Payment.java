package vp.testing.payment;

public class Payment {
	private int totalAmount = 0;
	
	public int pay(int amount) {
		totalAmount += amount;
		return totalAmount;
	}
	
	public int getTotal() {
		return totalAmount;
	}
}
