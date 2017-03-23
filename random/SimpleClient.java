import java.io.*;
import java.net.*;

class SimpleClient {

	public static void main (String[] args) {
		SimpleClient c = new SimpleClient();
		c.go();
	}
	
	public void go() {
		
		try{
			Socket sock = new Socket("127.0.0.1", 5000);
		
			System.out.println("Procurando servidor...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			System.out.println("Recebendo mensagem...");
			System.out.println(reader.readLine());

			reader.close();
		}catch (Exception ex) {ex.printStackTrace();}
		
	}

}