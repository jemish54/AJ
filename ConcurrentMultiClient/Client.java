import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        try {
            Socket s = new Socket("localhost",9999);
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter the String :");
            out.println(kb.nextLine());
            String revStr = in.nextLine();
            System.out.println("Reversed String is : "+revStr);
            kb.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
