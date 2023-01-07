package ECard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPrueba {
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(7777)){
			System.out.println("Servidor en marcha");
			while(true) {
				try(Socket s = server.accept(); DataInputStream dis = new DataInputStream(s.getInputStream());
						DataOutputStream dos = new DataOutputStream(s.getOutputStream())){
						dos.writeBytes("Te conectaste\s\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
