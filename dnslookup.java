import java.net.*;

public class dnslookup {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DNSLookup <IP address or URL>");
            return;
        }

        String input = args[0];

        try {
            InetAddress address = InetAddress.getByName(input);
            String hostName = address.getHostName();
            String hostAddress = address.getHostAddress();

            System.out.println("Input: " + input);
            System.out.println("URL: " + hostName);
            System.out.println("IP Address: " + hostAddress);
        } catch (Exception e) {
            System.out.println("Unable to perform DNS lookup for " + input);
        }
    }
}
