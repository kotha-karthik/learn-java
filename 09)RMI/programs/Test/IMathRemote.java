public interface IMathRemote extends java.rmi.Remote
{
    public int add(int a, int b) throws java.rmi.RemoteException;
    public int sub(int a, int b) throws java.rmi.RemoteException;
}
