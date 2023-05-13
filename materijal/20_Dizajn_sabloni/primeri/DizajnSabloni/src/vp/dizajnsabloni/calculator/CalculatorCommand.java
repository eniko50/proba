package vp.dizajnsabloni.calculator;

/*
 * concrete command
 */
public class CalculatorCommand implements Command {

	public CalculatorCommand(Calculator calculator, char operator, double operand) {
		super();
		this.operator = operator;
		this.operand = operand;
		this.calculator = calculator;
	}

	private char operator;
	
	private double operand;
	
	private Calculator calculator;
	
	
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void execute() {
		calculator.operation(operator, operand);
	}

	@Override
	public void unExecute() {
		//ponistavanje komande je izvrsavanje njene inverzne operacije
		calculator.operation(inverse(operator), operand);
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public double getOperand() {
		return operand;
	}

	public void setOperand(double operand) {
		this.operand = operand;
	}

	private char inverse(char operand){
		if(operand == '+'){
			return '-';
		}
		else if(operand == '-'){
			return '+';
		}
		else if(operand == '*'){
			return '/';
		}
		else if(operand == '/'){
			return '*';
		}
		else{
			return ' ';
		}
	}
}
