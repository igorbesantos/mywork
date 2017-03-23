import java.io.*;
import java.net.*;

class SimpleServer {

	String message=("Conectado!");


	public static void main(String[] args){
		SimpleServer s = new SimpleServer();
		s.go();
	}
	
	
	public void go() {
		
		try {

		ServerSocket socket = new ServerSocket(5000);
		
			while (true) {
				
				System.out.println("Aguardando cliente...");
				Socket clientSocket = socket.accept();
				System.out.println("Cliente Encontrado");
				
				System.out.println("Enviando Mensagem...");
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

				writer.println(message);
				writer.close();

				System.out.println("Mensagem Enviada!("+message+")");
				
			}

		} catch (Exception ex) {ex.printStackTrace();}
	}

}
