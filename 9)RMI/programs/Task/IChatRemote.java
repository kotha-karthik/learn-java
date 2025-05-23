import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
public interface IChatRemote extends Remote
{
	public void connect(String username,IChatClient cc) throws java.rmi.RemoteException;
	public void send(String username,String msg) throws java.rmi.RemoteException;
	public List<> listAll() throws java.rmi.RemoteException;
}
