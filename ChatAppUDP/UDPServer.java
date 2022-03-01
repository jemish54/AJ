import java.net.*;
import java.util.Scanner;

class UDPServer {
    public static void main(String args[]) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();

        DatagramSocket ds = new DatagramSocket(9999);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message: \n=> ");
            String msg = sc.nextLine();
            DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, 8888);
            ds.send(dp);
            if(msg.equals("bye")) break;

            byte[] buff = new byte[1024];
            dp = new DatagramPacket(buff, 1024);
            ds.receive(dp);
            String msgFromClient = new String(dp.getData(), 0, dp.getLength());

            System.out.println("Received Message: ");
            System.out.println("=> " + msgFromClient);

            if(msgFromClient.equals("bye")) break;
        }

        sc.close();
        ds.close();
    }
}