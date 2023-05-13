package vp.internet.mreznoprogramiranje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
	public static void main(String[] args) {
		ServerSocket ss;
		try {
			ss = new ServerSocket(9100);
			Socket sock = ss.accept();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream())), true);
			
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
