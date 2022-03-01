import java.net.*;
import java.io.*;
import java.util.*;

class Server{
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Waiting ....");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            Scanner sc = new Scanner(is);
            Scanner kb = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(os,true);
            String msg="";
            while(true){
                msg = sc.nextLine();
                System.out.println(msg);
                if(msg.equals("bye")) 
                {   
                    break;
                }
                System.out.println("Enter message : ");
                String clientmsg = kb.nextLine();
                pw.println(clientmsg);
            }
            kb.close();
            ss.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}