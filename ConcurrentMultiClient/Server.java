import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server{
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("Waiting");
            ExecutorService pool = Executors.newFixedThreadPool(4);
            while(true){
                Socket s = ss.accept();
                System.out.println("Connected to a Client");
                ClientHandler client = new ClientHandler(s);
                pool.execute(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable{

    private Socket clientSocket;
    private Scanner in;
    private PrintWriter out;


    public ClientHandler(Socket s) throws IOException{
        clientSocket = s;
        in = new Scanner(clientSocket.getInputStream());
        out = new PrintWriter(clientSocket.getOutputStream(),true);
    }

    @Override
    public void run() {
        String str = in.nextLine();
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        out.println(sb.toString());
    }

}