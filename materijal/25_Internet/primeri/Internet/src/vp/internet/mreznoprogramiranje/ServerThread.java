package vp.internet.mreznoprogramiranje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerThread extends Thread {
	
	BufferedReader in;
	PrintWriter out;
	Socket sock;
	
	public ServerThread(Socket sock) {		
		try {
			this.sock = sock;
			
			in = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream())), true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			String request = in.readLine();
			System.out.println("Klijent je poslao poruku: " + request);
			out.println(LocalDateTime.now().toString());
			
			in.close();
			out.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
