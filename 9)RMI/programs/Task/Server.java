import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
            ChatRemote chatRemote = new ChatRemote();
            Naming.rebind("ChatService", chatRemote);
            System.out.println("Chat Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
