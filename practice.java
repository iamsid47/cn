import java.net.*;
import java.io.*;
import java.util.*;

public class practice {

    public static void main (String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);
        System.out.println("listening on port 8090");

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("client: " + message);

        System.out.println("Enter msg for client: ");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        byte[] sendData = msg.getBytes();


        InetAddress clInetAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clInetAddress, clientPort);
        socket.send(sendPacket);

        scanner.close();
        socket.close();
    }
}