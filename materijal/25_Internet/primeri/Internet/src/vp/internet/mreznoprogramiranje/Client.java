package vp.internet.mreznoprogramiranje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			Socket sock = new Socket(address, 9100);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream())), true);
			
			out.println("Trenutni datum i vreme");
			String response = in.readLine();
			
			System.out.println("Odgovor servera je: " + response);
			
			out.close();
			in.close();
			sock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
