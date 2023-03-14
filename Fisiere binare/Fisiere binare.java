import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
        int contor=0;
        double suma=0;
        double medie=0;
        FileInputStream fis = new FileInputStream("D:\\Programming\\Facultate\\FisiereBinare\\numere.dat");
        DataInputStream d = new DataInputStream(fis);
        //Calculez cati octeti are fisierul:
        File f = new File("D:\\Programming\\Facultate\\FisiereBinare\\numere.dat");
        long nrOcteti = f.length();
        int N = (int) nrOcteti / 4; //cate nr. intregi sunt in fisier
        int i;
        for (i = 1; i <= N; i++) {
            int nr = d.readInt();
            if (nr%2==0){
                contor++;
                suma=suma+nr;
            }
        }
        if (contor==0){
            System.out.println("NU EXISTA NUMERE PARE");
        }
        else if(contor>0){
            medie=suma/contor;
            System.out.println(medie);
        }
        d.close();
        fis.close();
    }catch(IOException ignored){}
    }
}