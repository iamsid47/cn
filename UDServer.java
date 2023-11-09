import java.net.*;
import java.io.*;
import java.util.*;

public class UDServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9876);
        System.out.println("Listening on port: 9876");

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Client sent you a message: " + message);

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        System.out.println("Enter a message for client:");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        byte[] sendData = msg.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        socket.send(sendPacket);

        scanner.close();
        socket.close();
    }
}
