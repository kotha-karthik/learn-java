import java.rmi.server.UnicastRemoteObject;

public class MathRemote extends UnicastRemoteObject implements IMathRemote
{
    // Constructor
    public MathRemote() throws java.rmi.RemoteException
    {
        super();
    }

    public int add(int a, int b) throws java.rmi.RemoteException
    {
        System.out.println("Adding " + a + " and " + b);
        return a + b;
    }
    
    public int sub(int a, int b) throws java.rmi.RemoteException
    {
        System.out.println("Subtracting " + b + " from " + a);
        return a-b;
	}
}
