public class Client {
    public static void main(String[] args) {
        try {
            IMathRemote mathRemote = (IMathRemote) java.rmi.Naming.lookup("rmi://localhost/MathRemote");
            int resultAdd = mathRemote.add(5, 3);
            System.out.println("Result of addition: " + resultAdd);
            
            int resultSub = mathRemote.sub(5, 3);
            System.out.println("Result of subtraction: " + resultSub);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
		}
	}
}
