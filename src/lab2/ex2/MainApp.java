package lab2.ex2;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;



public class MainApp{
    public static void main(String[] args)throws IOException {
        File cantec_out = new File("Laboratoare/src/lab2/ex2/cantec_out.txt");
        File cantec_in = new File("Laboratoare/src/lab2/ex2/cantec_in.txt");

        try {
            if (cantec_out.createNewFile()) {
                System.out.println("Fisier creat");
            }
        } catch (IOException e) {
            System.out.println("Eroare la crearea fisierului");
        }

        Vers[] vers = new Vers[100];
        int nrVersuri = 0;

        try (Scanner sc = new Scanner(cantec_in)) {
            while (sc.hasNextLine() && nrVersuri < vers.length) {
                String linie = sc.nextLine();
                vers[nrVersuri] = new Vers(linie);
                nrVersuri++;
            }
        }catch (IOException e){
            System.out.println("Eroare la citire din fisier");
        }

        String tastatura;

        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Introduceti siru de caractere ");
            tastatura = sc.nextLine();
        }

        try(PrintStream out = new PrintStream(cantec_out)){
            for(int i = 0; i<nrVersuri;i++){
                String nr_cuv;
                String nr_voc;
                if(vers[i].nr_cuv() != 0){
                    nr_cuv = String.valueOf(vers[i].nr_cuv());
                }else{
                    nr_cuv = "";
                }

                if(vers[i].nr_voc() != 0){
                    nr_voc = String.valueOf(vers[i].nr_voc());
                }else{
                    nr_voc = "";
                }

                out.println(vers[i].randMajuscule() + " " + nr_cuv + " " + nr_voc + " " + vers[i].steluta(tastatura));
            }
        }

    }
}
