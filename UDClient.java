import java.net.*;
import java.io.*;
import java.util.*;

public class UDClient {

    public static void main (String[] args) throws IOException {
        String hostAddress = "localhost";
        int hostPort = 8080;

        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a msg: ");
        String msg = scanner.nextLine();
        byte[] sendData = msg.getBytes();

        InetAddress serverAddress = InetAddress.getByName(hostAddress);
        int serverPort = hostPort;

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        socket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivDatagramPacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivDatagramPacket);

        String response = new String(receivDatagramPacket.getData(), 0, receivDatagramPacket.getLength());
        System.out.println("server says: " + response);

        scanner.close();
        socket.close();
    }
}