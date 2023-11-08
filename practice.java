import java.net.*;

public class practice {

    public static void main (String[] args) {
        if (args.length != 1) {
            System.out.println("Please add the url/ip along with program name");
            System.out.println("Usage: java dnslookup <IP/URL HERE>");
        }

        String input = args[0];

        try {
            InetAddress address = InetAddress.getByName(input);
            String hostName = address.getHostName();
            String hostAddress = address.getHostAddress();

            System.out.println("Host Address: " + hostName);
            System.out.println("Host Address: " + hostAddress);
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }
    }
}