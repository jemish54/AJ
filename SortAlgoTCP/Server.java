import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("Waiting");
            Socket s = ss.accept();
            System.out.println("Connected");
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            PrintWriter pw = new PrintWriter(os,true);
            Scanner sc = new Scanner(is);
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int[] sortedA = InsertionSort(a,n);
            for(int i=0;i<n;i++){
                pw.println(sortedA[i]);
            }
            sc.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int[] InsertionSort(int[] a,int n){
        for(int i=1;i<n;i++){
            int temp = a[i];
            int j = i-1;
            while(j>0 && temp<a[j]){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1]=temp;
        }
        return a;
    }
}