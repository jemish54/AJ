import java.net.*;
import java.util.Scanner;
import java.io.*;

class Client{
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost",8888);
            System.out.println("Connected To Server");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            Scanner sc = new Scanner(is);
            Scanner kb = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(os,true);
            //pw.println("Hello server");
            String servermsg = "";
            while(true){
                System.out.println("Enter message : ");
                servermsg = kb.nextLine();
                if(servermsg.equals("bye")) 
                {   pw.println(servermsg);
                    break;
                }
                pw.println(servermsg);
                String msg = sc.nextLine();
                System.out.println(msg);
            }
            kb.close();
            sc.close();
            is.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}