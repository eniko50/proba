package vp.ds.ispiti;

import java.util.Stack;

import vp.ds.ispiti.komande.Komanda;

/**
 * Ova klasa ima ulogu Invoker-a:
 * njoj se prosledjuju komande na izvrsavanje.
 * Sadrzi undo stack komandi, tako da moze i da ponistava izvrsene komande.
 */
public class CommandManager {
	
	private static CommandManager instanca = new CommandManager();
	private Stack<Komanda> komande;
	
	private CommandManager() {
		komande = new Stack<Komanda>();
	}
	
	public static CommandManager getInstance() {
		return instanca;
	}
	
	/**
	 * Metoda koja izvrsava komandu i ubacuje je u undo stack
	 */
	public void izvrsi(Komanda komanda) {
		komande.push(komanda);
		komanda.izvrsi();
	}

	/**
	 * Metoda koja ponistava (undo) komandu i izbacuje je iz undo stack-a
	 */
	public void ponisti() {
		if (komande.size() > 0) {
			Komanda komanda = komande.pop();
			komanda.ponisti();
		}
	}
}
