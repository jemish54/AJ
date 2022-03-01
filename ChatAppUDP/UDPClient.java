import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(8888);
        InetAddress ip = InetAddress.getLocalHost();
        Scanner sc = new Scanner(System.in);

        while (true) {
            byte[] buff = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buff, 1024);
            ds.receive(dp);
            String msgFromServer = new String(dp.getData(), 0, dp.getLength());

            System.out.println("Received Message: ");
            System.out.println("=> " + msgFromServer);

            if(msgFromServer.equals("bye")) break;

            System.out.print("Enter message: \n=> ");
            String msg = sc.nextLine();
            dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, 9999);
            ds.send(dp);
            if(msg.equals("bye")) break;
        }

        sc.close();
        ds.close();
    }
}
