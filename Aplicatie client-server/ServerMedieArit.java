import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;

public class ServerMedieArit {
    public static void main(String[] args) {
        System.out.println("Am pornit server...");
        try{
            ServerSocket ss=new ServerSocket(5000);
            for(;;) {
                Socket cs = ss.accept();
                Thread firPtClient = new Thread(new MotorFirClient(cs));
                firPtClient.start();
                System.out.println("Avem o conectare!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class MotorFirClient implements Runnable{
    private Socket cs;
    private BufferedReader bfr;
    public MotorFirClient(Socket clientsock){
        try{
            cs=clientsock;
            PrintWriter pw = new PrintWriter(cs.getOutputStream());
            InputStreamReader isr=new InputStreamReader(cs.getInputStream());
            bfr=new BufferedReader(isr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        String textIn;
        try{
            for(;;){
                textIn=bfr.readLine();
                if(textIn.equals(""))break;
                StringTokenizer tk = new StringTokenizer(textIn);
                int n=tk.countTokens();
                int suma=0;
                for (int i=1;i<=n;i++){
                    int nrCrt=Integer.parseInt(tk.nextToken());
                    suma=suma+nrCrt;
                }
                PrintWriter pw = new PrintWriter(cs.getOutputStream());
                //pw.println(suma+" "+n);
                //pw.flush();
                double medie =suma/(double)n;
                pw.println("medie aritmetica="+medie);
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}