package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContBancar cont= new ContBancar();
        cont.Meniu();
    }
}


public class ContBancar {

    int sold, Tranzactie_precedenta;;

    void sold_curent(){
        System.out.println(sold);
    }

    void adaugare(int suma){
        if(suma != 0){
            sold+= suma;
            Tranzactie_precedenta=suma;
        }
    }

    void retragere(int suma){
        if(sold > suma){
            sold-=suma;
            Tranzactie_precedenta= -suma;
        }
    }

    void Ultima_tranzactie(){
        if(Tranzactie_precedenta > 0)
            System.out.println("Ultima adaugare : " + Tranzactie_precedenta);
        else {
            if (Tranzactie_precedenta < 0) {
                System.out.println("Ultima retragere : " + Tranzactie_precedenta);
            } else {
                System.out.println(" Nu s-a efectuat nicio tranzactie !");
            }
        }
    }
    void Meniu(){
        char option='\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bun venit!");
        System.out.println("Selectati optiunea dorita :");
        System.out.println();
        System.out.println(" Tastati \"A \"pentru a vizualiza sold-ul. ");
        System.out.println(" Tastati \"B \"pentru a adauga bani.");
        System.out.println(" Tastati \"C \"pentru a retrage bani.");
        System.out.println(" Tastati \"D \"pentru a afisa tranzactia precedenta.");
        System.out.println(" Tastati \"E \"pentru a iesi. ");
        System.out.println();

        do{
            System.out.println();
            option = scanner.next().charAt(0);
            System.out.println();
            switch (option){
                case 'A' :
                    System.out.println("Aveti suma de " + sold + " in cont.");
                    break;

                case 'B':
                    System.out.println("Introduceti suma pe care doriti sa o adaugati : ");
                    int suma = scanner.nextInt();
                    adaugare(suma);
                    break;
                case 'C':
                    System.out.println("Introduceti suma pe care doriti sa o retrageti : ");
                    int suma2 = scanner.nextInt();
                    retragere(suma2);
                    break;
                case 'D':
                    Ultima_tranzactie();
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("N-ai introdus ce trebuie! Mai incearca.");
                    break;
            }
        }while(option != 'E');

        System.out.println("Multumim !");
    }
}
