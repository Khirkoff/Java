import javax.security.auth.callback.TextInputCallback;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Am pornit server...");
        try{
            ServerSocket ss=new ServerSocket(5000);
            for(;;){
                Socket cs=ss.accept();
                FirClient firPtClient=new FirClient(cs);
                firPtClient.start();
                System.out.println("Avem o conectare!");
            }//for;;
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
class FirClient extends Thread{
    private Socket cs;
    private BufferedReader bfr;
    private PrintWriter pw;
    //constructorul clasei:
    public FirClient(Socket clientsock)
    {
        try{
            cs=clientsock;
            pw=new PrintWriter(cs.getOutputStream())	;
            InputStreamReader isr= new InputStreamReader(cs.getInputStream());
            bfr=new BufferedReader(isr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run()
    {
        String textIn;
        StringBuilder S= new StringBuilder();
        int nr=0;
        try{
            for(;;){
                nr++;
                textIn=bfr.readLine();
                S.append(textIn);
                S.append(" ");
                if (nr==2){
                    break;
                }
            }//for;;
            pw.println("SUCCES "+S+ "!");
            pw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//run
}
