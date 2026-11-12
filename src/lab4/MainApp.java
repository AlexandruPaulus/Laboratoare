package lab4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainApp {
    static void main(String[] args)throws IOException {
        List<Echipament> echipamente = new ArrayList<>();
        File electronice = new File("Laboratoare/src/lab4/electronice.txt");
        Scanner sc = new Scanner(electronice);
        while(sc.hasNextLine()){
            String linie = sc.nextLine();
            if(linie .isEmpty()){
                continue;
            }
            String[] campuri = linie.trim().split("\\s*;\\s*");
            String denumire = campuri[0];
            int numar_inventar = Integer.valueOf(campuri[1]);
            double pret = Double.valueOf(campuri[2]);
            Echipament.ZonaMag zonaMag = Echipament.ZonaMag.valueOf(campuri[3]);
            Echipament.StareProdus stareProdus = Echipament.StareProdus.valueOf(campuri[4]);
            String tip = campuri[5].toLowerCase();
            switch (tip){
                case "imprimanta":
                    int nr_pg_min = Integer.valueOf(campuri[6]);
                    int rezolutie = Integer.valueOf(campuri[7]);
                    int nr_pg_cartus = Integer.valueOf(campuri[8]);
                    Imprimanta.ModTiparire modTiparie = Imprimanta.ModTiparire.valueOf(campuri[9]);
                    echipamente.add(new Imprimanta(denumire,numar_inventar,pret,zonaMag,stareProdus,nr_pg_min,rezolutie,nr_pg_cartus,modTiparie));
                    break;

                case "copiator":
                    int nr_pagini_toner = Integer.valueOf(campuri[6]);
                    Copiator.FormatCopiere formatCopiere = Copiator.FormatCopiere.valueOf(campuri[7]);
                    echipamente.add(new Copiator(denumire,numar_inventar,pret,zonaMag,stareProdus,nr_pagini_toner,formatCopiere));
                    break;

                case "sistem de calcul":
                    double vit_procesor = Double.valueOf(campuri[6]);
                    int stocare = Integer.valueOf(campuri[7]);
                    SistemDeCalcul.TipMonitor tipMonitor = SistemDeCalcul.TipMonitor.valueOf(campuri[8]);
                    SistemDeCalcul.SistemOperare sistemOperare = SistemDeCalcul.SistemOperare.valueOf(campuri[9]);
                    echipamente.add(new SistemDeCalcul(denumire,numar_inventar,pret,zonaMag,stareProdus,vit_procesor,stocare,tipMonitor,sistemOperare));
                    break;
            }
        }
        int c;
        Scanner sc1 = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("1.Afişarea tuturor echipamentelor");
            System.out.println("2.Afişarea imprimantelor");
            System.out.println("3.Afişarea copiatoarelor");
            System.out.println("4.Afişarea sistemelor de calcul");
            System.out.println("5.Modificarea stării în care se află un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9.Afişarea echipamentelor vândute");
            System.out.println("10. Serialiarea obiectelor/desearizarea colectiei de obiecte");
            System.out.println("11. Exit");
            System.out.println();
            do{
                c = sc1.nextInt();
                sc1.nextLine();
                if(c < 1 || c > 11){
                    System.out.println("Introduceti o valoare intre 1-11");
                }
            }while(c < 1 || c > 11);

            switch (c){
                case 1:
                    for(Echipament e: echipamente){
                        System.out.println(e.toString());
                    }
                    break;

                case 2:
                    System.out.println("*****Imprimante*****");
                    for(Echipament e: echipamente){
                        if(e instanceof Imprimanta){
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.println("*****Copiatoare*****");
                    for(Echipament e: echipamente){
                        if(e instanceof Copiator){
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    System.out.println("*****Sisteme de calcul*****");
                    for(Echipament e:echipamente){
                        if(e instanceof SistemDeCalcul){
                            System.out.println(e);
                        }
                    }
                    break;

                case 5:
                    String denumire;
                    String denumireStare = "";
                    int stare=0;
                    boolean verificare = false;
                    do {
                        System.out.print("Introduceti denumirea produsului pentru care modificati starea ");
                        denumire = sc1.nextLine();
                        for(Echipament e:echipamente){
                            if(e.getDenumire().equals(denumire)) {
                                verificare = true;
                                do {
                                    System.out.println("1.ACHIZITIONAT 2.EXPUS 3.VANDUT");
                                    stare = sc1.nextInt();
                                } while (stare != 1 && stare != 2 && stare != 3);

                                switch (stare) {
                                    case 1:
                                        denumireStare = "ACHIZITIONAT";
                                        break;

                                    case 2:
                                        denumireStare = "EXPUS";
                                        break;

                                    case 3:
                                        denumireStare = "VANDUT";
                                        break;
                                }
                                System.out.println("Stare modificata");
                                e.setStareProdus(denumireStare);
                            }
                        }
                    }while(!verificare);
                    break;

                case 6:
                    String denumireImprimanta;


                    break;
                case 11:
                    exit(0);
                    break;
            }
        }
    }
}
