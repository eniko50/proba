package vp.testing.payment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPayment {
	@Test
	public void testPay() {
		Payment payment = new Payment();
		int total = payment.pay(1000);
		
		assertEquals(1000, total);
		
		total = payment.pay(500);
		
		assertEquals(1500, total);
	}
	
	@Test
	public void testGetTotal() {
		Payment payment = new Payment();
		payment.pay(1000);
		payment.pay(500);
		
		int total = payment.getTotal(); 
		assertEquals(1500, total);
	}
}
