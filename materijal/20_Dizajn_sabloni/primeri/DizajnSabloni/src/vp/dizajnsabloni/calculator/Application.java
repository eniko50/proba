package vp.dizajnsabloni.calculator;

import java.util.ArrayList;

/*
 * client/invoker
 */
public class Application {

	//da bismo bili sigurni da radimo sa tacno jednom verzijom aplikacije,
	//klasa Application je singleton
	private Application() {
		calculator = new Calculator();
		commands = new ArrayList<Command>();
	}

	private static Application instance = new Application();

	public static Application getInstance() {
		return instance;
	}

	private Calculator calculator;
	private ArrayList<Command> commands;

	private int current = 0;

	public void compute(char operator, double operand) {
		// kreiranje i izvrsavanje komande
		Command command = new CalculatorCommand(calculator, operator, operand);
		command.execute();

		// dodavanje komande u listu, da bi kasnije mogla da se ponisti
		commands.add(command);
		current++;
	}

	/*
	 * ponistavanje komandi. Zadaje se koliko prethodnih komandi treba da se
	 * ponisti
	 */
	public void undo(int levels) {
		System.out.println("\n---- Undo " + levels + " levels ");
		// ponistavanje komandi
		for (int i = 0; i < levels; i++) {
			if (current >= 0) {
				// preuzimanje komande iz liste
				Command command = commands.get(--current);
				// ponistavanj komande
				command.unExecute();
			}
		}
	}

	/*
	 * ponovno izvrsavanje komande
	 */
	public void redo(int levels) {
		System.out.println("\n---- Redo " + levels + " levels ");
		for (int i = 0; i < levels; i++) {
			if (current < commands.size()) {
				Command command = commands.get(current++);
				command.execute();
			}
		}
	}
}
