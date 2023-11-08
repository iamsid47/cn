import java.net.*;
import java.io.*;
import java.util.*;

public class cpractice {

    public static void main (String[] args) throws IOException {
        String serverHost = "localhost";
        int serverPort = 8090;

        Socket socket = new Socket(serverHost, serverPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message you want to send to server: ");
        String scanText = scanner.nextLine();

        out.println(scanText);

        String response = in.readLine();
        System.out.println("Server response: " + response);

        scanner.close();
        socket.close();
    }
}