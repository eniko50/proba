package vp.standardniulazizlaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)  {
		//klasa String
		String s = "Beograd";
		int duzina = s.length(); 
		System.out.println("Duzina stringa je: " + duzina);
		
		char c = s.charAt(2);
		System.out.println("Karakter na poziciji 2 je: " + c);
		
		int i = s.indexOf('g');
		System.out.println("Karakter g nalazi se na poziciji " + i);
		
		String s1 = s.substring(2, 5); 
		System.out.println("Podstring je: " + s1);
		
		boolean b = s.startsWith("Beo");  
		System.out.println("String pocinje na Beo? " + b);
		
		String s2 = s.toLowerCase();
		System.out.println("String malim slovima je: " + s2);
		
		//standardni ulaz i izlaz
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in)); 
		System.out.print("Unesite Vase ime: ");
		try {
			String ime = in.readLine();
			System.out.println("Vase ime je: " + ime);
			
			System.out.print("Unesite koliko imate godina: ");
			String godineUnos = in.readLine();
			int godine = Integer.parseInt(godineUnos);
			System.out.println("Vas broj godina je: " + godine);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
