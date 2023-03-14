import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Socket cs=null;
        BufferedReader bfr=null;
        PrintWriter pw=null;
        try{
            cs=new Socket("localhost",5000)	 ;
            InputStreamReader isr= new InputStreamReader(cs.getInputStream());
            bfr=new BufferedReader(isr);
            pw=new PrintWriter(cs.getOutputStream());
            System.out.println("S-a setat reteaua");
            System.out.print("Nume:");
            String Nume= sc.nextLine();
            System.out.print("Prenume:");
            String Prenume= sc.nextLine();
            int nr=0;
            for(;;) {
                if (Nume.equals("STOP")) {
                    System.out.println("Nume=STOP");
                    System.out.println("deconectare");
                    break;
                } else {
                    nr++;
                }
                if (Prenume.equals("STOP")) {
                    System.out.println("Prenume=STOP");
                    System.out.println("deconectare");
                    break;
                } else {
                    nr++;
                }
                if (nr == 2) {
                    pw.println(Nume);
                    pw.flush();
                    pw.println(Prenume);
                    pw.flush();
                }
                String textIn = bfr.readLine();
                System.out.println(textIn);
                break;
            }
        }catch( IOException e){
            e.printStackTrace();
        }
    }//main
}