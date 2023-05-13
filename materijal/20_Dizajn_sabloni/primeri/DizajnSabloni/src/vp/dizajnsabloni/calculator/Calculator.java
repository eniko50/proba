package vp.dizajnsabloni.calculator;

/*
 * receiver
 */
public class Calculator {
	
	private double current = 0;

	public void operation(char operator, double operand) {
		if (operator == '+') {
			current += operand;
		} else if (operator == '-') {
			current -= operand;
		} else if (operator == '*') {
			current *= operand;
		} else if (operator == '/') {
			current /= operand;
		}
		System.out.println("Current value = " + current + " after " + operator
				+ " " + operand);
	}
}
