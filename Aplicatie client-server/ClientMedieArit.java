import java.net.*;
import java.io.*;
import java.util.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMedieArit {
    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        Socket cs=null;
        BufferedReader bfr = null;
        PrintWriter pw = null;
        try{
            cs=new Socket("localhost",5000);
            InputStreamReader isr= new InputStreamReader(cs.getInputStream());
            bfr = new BufferedReader(isr);
            pw=new PrintWriter(cs.getOutputStream());
            System.out.println("S-a setat reteaua");
            for(;;){
                System.out.print("N=");
                N= scanner.nextInt();
                if(N==0){
                    pw.println("");
                    pw.flush();
                    break;
                }
                StringBuilder s= new StringBuilder();
                for (int i=0;i<N;i++){
                    System.out.print("nr=");
                    s.append(scanner.nextInt());
                    s.append(" ");
                }
                pw.println(s);pw.flush();
                String textIn=bfr.readLine();
                if (textIn==null)break;
                System.out.println(textIn);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}