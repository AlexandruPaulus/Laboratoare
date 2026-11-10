package lab2.ex4;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)throws IOException {

        int numarPersoane;
        String nume,cnp;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane ");
        numarPersoane = sc.nextInt();
        sc.nextLine();
        Persoana[] persoana = new Persoana[numarPersoane];

        for(int i=0;i<numarPersoane;i++){
            System.out.print("Introduceti nemele ");
            nume = sc.nextLine();
            System.out.print("Introduceti CNP ");
            cnp = sc.nextLine();
            persoana[i] = new Persoana(nume,cnp,0);
            while(persoana[i].verificare() == false){
                System.out.print("Reintroduceti cnp-ul ");
                cnp = sc.nextLine();
                persoana[i].setCNP(cnp);
            }
            persoana[i].varsta();
        }
        for(int i=0;i<numarPersoane;i++){
            System.out.println(persoana[i].toString());
        }

    }
}
