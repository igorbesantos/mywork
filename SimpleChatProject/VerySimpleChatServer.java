import java.io.*;
import java.net.*;
import java.util.*;

public class VerySimpleChatServer {
	ArrayList<PrintWriter> clientOutputStreams;
	private int serverSocketPort;
	
	public VerySimpleChatServer (int portNumber) {
		this.serverSocketPort = portNumber;
	}

	public class ClientHandler implements Runnable {
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler (Socket clientSocket) { //Construtor atribui o socket  do cliente na criação do objeto
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {ex.printStackTrace();}
		}
		
		public void run(){
			String message;
			try{
				while((message=reader.readLine()) != null){
					System.out.println("read "+message);
					tellEveryone(message);
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
	}

	public static void main(String[] args){
		new VerySimpleChatServer(Integer.parseInt(args[0])).go();
	}

	public void go() {
		clientOutputStreams = new ArrayList<PrintWriter>();
		try {
			ServerSocket serverSocket = new ServerSocket(this.serverSocketPort);
			while(true){
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	public void tellEveryone (String message){
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
}
