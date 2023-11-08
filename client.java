import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        String serverHost = "localhost";
        int serverPort = 8090;

        Socket socket = new Socket(serverHost, serverPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello, Server!");

        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}
