import java.net.*;
import java.io.*;

class Server{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            FileInputStream fis = new FileInputStream("sent.txt");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            int c;
            System.out.println("File Transfer Started");
            while((c=fis.read())!=-1){
                dout.write(c);
            }
            System.out.println("File Transfer Completed");
            s.close();
            fis.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}