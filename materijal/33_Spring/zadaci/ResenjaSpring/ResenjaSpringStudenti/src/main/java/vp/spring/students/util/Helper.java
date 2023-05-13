package vp.spring.students.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
	public static String input() {
		String text = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			 text = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
}
