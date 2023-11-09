import java.net.*;
import java.io.*;
import java.util.*;

public class client {

    public static void main (String[] args) throws IOException {
        String hostAddress = "localhost";
        int hostPort = 8080;

        Socket socket = new Socket(hostAddress, hostPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        System.out.println("Enter a message to send to server: ");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        out.println(msg);

        String response = in.readLine();

        System.out.println("The server says: " + response);


        scanner.close();
        socket.close();
    }
}