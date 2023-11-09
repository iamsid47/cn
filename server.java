import java.net.*;
import java.io.*;
import java.util.*;

public class server {

    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Listening on port: 8080");
        Socket clienSocket = serverSocket.accept();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);

        String message = in.readLine();

        System.out.println("Client sent you a message: " + message);

        System.out.println("Enter a message for client:");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        // String demo = "Gelloooo";

        out.println(msg);

        scanner.close();
        clienSocket.close();
        serverSocket.close();
    }
}
