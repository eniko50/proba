package vp.dizajnsabloni.calculator;

public class TestCalculator {
	public static void main(String[] args) {
		Application.getInstance().compute('+', 3);
		Application.getInstance().compute('-', 2.5);
		Application.getInstance().compute('*', 7);
		Application.getInstance().compute('/', 2);

		Application.getInstance().undo(3);
		Application.getInstance().redo(2);
	}
}
