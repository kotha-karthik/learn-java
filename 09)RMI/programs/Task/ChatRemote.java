import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
public class ChatRemote extends UnicastRemoteObject implements IChatRemote
{
	private HashMap<String,IChatClient> clients;
	public ChatRemote() throws RemoteException
	{
		clients=new HashMap<>();
	}
	public synchronized void connect(String username,IChatClient client)throws RemoteException
	{
		clients.put(username,client);
		System.out.println(username+" Connected");
	}
	public synchronized void send(String toUsername, String message) throws RemoteException {
        IChatClient client = clients.get(toUsername);
        if (client != null) {
            client.deliver(message); 
        } else {
            System.out.println("User not found: " + toUsername);
        }
    }

    public synchronized void listAll() throws RemoteException {
		return new ArrayList<>(clients.keySet());
	}

}

