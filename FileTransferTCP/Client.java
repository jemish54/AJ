import java.io.*;
import java.net.*;

class Client {
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost",9999);
            if(s.isConnected()){
                System.out.println("Connected To Server");
            }
            FileOutputStream fos = new FileOutputStream("received.txt");
            DataInputStream din = new DataInputStream(s.getInputStream());
            int c;
            while((c=din.read())!=-1){
                fos.write((char)c);
            }
            fos.close();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
