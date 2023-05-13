package vp.internet.mreznoprogramiranje;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiThread {
	public static void main(String[] args) {
		ServerSocket ss;
		
		try {
			ss = new ServerSocket(9100);
			
			while (true) {
				Socket sock = ss.accept();
				ServerThread st = new ServerThread(sock);
				st.start();
			}						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
