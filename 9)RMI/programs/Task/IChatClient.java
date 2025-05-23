public interface IChatClient extends java.rmi.Remote
{
	public void deliver(String msg) throws java.rmi.RemoteException;
}
