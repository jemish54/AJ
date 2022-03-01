import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 9999);
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            PrintWriter pw = new PrintWriter(os, true);
            Scanner sc = new Scanner(is);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter number of elements : ");
            int n = kb.nextInt();
            pw.println(n);
            System.out.println("Enter elements : ");
            for(int i=0;i<n;i++){
                pw.println(kb.nextInt());
            }
            System.out.println("Sorted Array is : ");
            for (int i = 0; i < n; i++) {
                System.out.print(sc.nextInt()+" ");
            }
            kb.close();
            sc.close();
            pw.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
