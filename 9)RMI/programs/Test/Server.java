public class Server {
    public static void main(String[] args) {
        try {
            
            IMathRemote mathRemote = new MathRemote();
            //IMathRemote stub =(MathRemote)UnicastRemoteObject.exportObject(mathRemote, 0);
            java.rmi.Naming.rebind("MathRemote", mathRemote);
            System.out.println("Server is ready.");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
	}
}
