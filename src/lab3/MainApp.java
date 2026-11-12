package lab3;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainApp {
    public static void main(String[] args)throws IOException {

        List<Produs> produse = new ArrayList<Produs>();
        File fisier_produse = new File("Laboratoare/src/lab3/produse.csv");
        File produse_out = new File("Laboratoare/src/lab3/produse_out.txt");
        PrintStream out = new PrintStream(produse_out);

        try(Scanner sc = new Scanner(fisier_produse)){
            while(sc.hasNextLine()){
                String linie = sc.nextLine().trim();
                if (linie.isEmpty()) {
                    continue;
                }
                String[] campuri = linie.split("\\s*,\\s*");
                String denumire = campuri[0];
                double pret = Double.parseDouble(campuri[1]);
                int cantitate = Integer.parseInt(campuri[2]);
                LocalDate data_expirare = LocalDate.parse(campuri[3].trim());

                produse.add(new Produs(denumire,pret,cantitate,data_expirare));
            }
        }catch (IOException e){
            System.out.println("Eroare la ciirea din fisier");
        }
        char c;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("a) afișarea tuturor produselor din colecția List");
            System.out.println("b) afișarea produselor expirate");
            System.out.println("c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.");
            System.out.println("d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)");
            System.out.println();
            System.out.print("Introduceti o valoare cuprinsa intre a si d ");
            c = sc.next().charAt(0);
            sc.nextLine();
            switch (c){
                case 'a':
                    System.out.println();
                    for(Produs p : produse){
                        System.out.println(p.toString());
                    }
                    break;

                case 'b':
                    for(Produs p : produse){
                        if(p.produse_expirate()){
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 'c':
                    String denumire_produs_vandut;
                    boolean verificare = false;
                    do {
                        System.out.print("Introduceti numele unui produs existent ");
                        denumire_produs_vandut = sc.nextLine();
                        for(Produs p : produse){
                            if(p.getDenumire().equals(denumire_produs_vandut)){
                                verificare = true;
                                if(verificare == true && p.vanzareProdus() == true){
                                    out.println(p.getDenumire() + ", " + p.getPret() + ", " + p.getData());
                                    produse.remove(p);
                                    System.out.println("Stocul este epuizat. Produsul a fost eliminat");
                                }
                                break;
                            }

                        }
                    }while(!verificare);
                    break;

                case 'd':
                    double valMax = Double.MAX_VALUE;
                    for(Produs p : produse){
                        if(valMax > p.getPret()){
                            valMax = p.getPret();
                        }
                    }
                    System.out.println();
                    for(Produs p: produse){
                        if(p.getPret() == valMax){
                            System.out.println(p.toString());
                        }
                    }
                    break;
                default: exit(0);
                    break;
            }}

    }
}
