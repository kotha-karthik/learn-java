import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ChatClient extends UnicastRemoteObject implements IChatClient {
    private String username;

    public ChatClient(String username) throws RemoteException {
        this.username = username;
    }

    public void deliver(String msg) throws RemoteException {
        System.out.println("Message Received -> " + msg);
    }

    public String getUsername() {
        return username;
    }
}
