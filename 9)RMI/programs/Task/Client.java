import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.print("Enter your name: ");
            String myName = System.console().readLine();

            IChatRemote chatRemote = (IChatRemote) Naming.lookup("rmi://localhost/ChatService");
            ChatClient myClient = new ChatClient(myName);

            chatRemote.connect(myName, myClient);

            while (true) {
                System.out.println("\n1. Send Message\n2. List Users\n3. Exit");
                int choice = Integer.parseInt(System.console().readLine());  

                if (choice == 1) {
                    System.out.print("Send to: ");
                    String to = System.console().readLine();
                    System.out.print("Message: ");
                    String msg = System.console().readLine();
                    chatRemote.send(to, myName + ": " + msg); 
                } else if (choice == 2) {
                    List<String> users = chatRemote.listAll();
                    System.out.println("Connected users:");
                    for (String user : users) {
                        System.out.println("- " + user);
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
