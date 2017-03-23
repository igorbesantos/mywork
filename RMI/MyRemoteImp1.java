import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImp1 extends UnicastRemoteObject implements MyRemote {

	public MyRemoteImp1() throws RemoteException{}

	public String sayHello() {
		return "Server says, hey";
	}

	public static void main(String[] args){
		try{
			MyRemote service = new MyRemoteImp1();
			Naming.rebing("Remote Hello", service);
		}catch(Exception ex){ex.printStackTrace();}
	}
}
