package lab4;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class MainApp {
    static void main(String[] args) throws IOException {
        List<Echipament> echipamente = new ArrayList<>();
        File electronice = new File("Laboratoare/src/lab4/electronice.txt");
        Scanner sc = new Scanner(electronice);
        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            if (linie.isEmpty()) {
                continue;
            }
            String[] campuri = linie.trim().split("\\s*;\\s*");
            String denumire = campuri[0];
            int numar_inventar = Integer.valueOf(campuri[1]);
            double pret = Double.valueOf(campuri[2]);
            Echipament.ZonaMag zonaMag = Echipament.ZonaMag.valueOf(campuri[3]);
            Echipament.StareProdus stareProdus = Echipament.StareProdus.valueOf(campuri[4]);
            String tip = campuri[5].toLowerCase();
            switch (tip) {
                case "imprimanta":
                    int nr_pg_min = Integer.valueOf(campuri[6]);
                    int rezolutie = Integer.valueOf(campuri[7]);
                    int nr_pg_cartus = Integer.valueOf(campuri[8]);
                    Imprimanta.ModTiparire modTiparie = Imprimanta.ModTiparire.valueOf(campuri[9]);
                    echipamente.add(new Imprimanta(denumire, numar_inventar, pret, zonaMag, stareProdus, nr_pg_min, rezolutie, nr_pg_cartus, modTiparie));
                    break;

                case "copiator":
                    int nr_pagini_toner = Integer.valueOf(campuri[6]);
                    Copiator.FormatCopiere formatCopiere = Copiator.FormatCopiere.valueOf(campuri[7]);
                    echipamente.add(new Copiator(denumire, numar_inventar, pret, zonaMag, stareProdus, nr_pagini_toner, formatCopiere));
                    break;

                case "sistem de calcul":
                    double vit_procesor = Double.valueOf(campuri[6]);
                    int stocare = Integer.valueOf(campuri[7]);
                    SistemDeCalcul.TipMonitor tipMonitor = SistemDeCalcul.TipMonitor.valueOf(campuri[8]);
                    SistemDeCalcul.SistemOperare sistemOperare = SistemDeCalcul.SistemOperare.valueOf(campuri[9]);
                    echipamente.add(new SistemDeCalcul(denumire, numar_inventar, pret, zonaMag, stareProdus, vit_procesor, stocare, tipMonitor, sistemOperare));
                    break;
            }
        }
        Scanner sc1 = new Scanner(System.in);
        boolean verificare = false;
        int alegere = 0;
        while (true) {
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
            System.out.println("10.Exit");
            System.out.println();
            do {
                try {
                    alegere = Integer.valueOf(sc1.nextLine().trim());
                } catch (NumberFormatException exception) {
                    System.out.println("Introduceti o valoare intre 1-10");
                }
            } while (alegere < 1 && alegere > 11);

            switch (alegere) {
                case 1:
                    for (Echipament e : echipamente) {
                        System.out.println(e.toString());
                    }
                    break;

                case 2:
                    System.out.println("*****Imprimante*****");
                    for (Echipament e : echipamente) {
                        if (e instanceof Imprimanta) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.println("*****Copiatoare*****");
                    for (Echipament e : echipamente) {
                        if (e instanceof Copiator) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    System.out.println("*****Sisteme de calcul*****");
                    for (Echipament e : echipamente) {
                        if (e instanceof SistemDeCalcul) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 5:
                    String denumireProdus;
                    String denumireStare = "";
                    alegere = 0;
                    verificare = false;
                    do {
                        System.out.print("Introduceti denumirea produsului pentru care modificati starea ");
                        denumireProdus = sc1.nextLine();
                        for (Echipament e : echipamente) {
                            if (e.getDenumire().equals(denumireProdus)) {
                                verificare = true;
                                do {
                                    System.out.println("1.ACHIZITIONAT 2.EXPUS 3.VANDUT");
                                    try {
                                        alegere = Integer.valueOf(sc1.nextLine().trim());
                                    } catch (NumberFormatException exception) {
                                        System.out.println("Introduceti o valoare cuprinsa intre 1 si 3");
                                    }

                                } while (alegere != 1 && alegere != 2 && alegere != 3);

                                switch (alegere) {
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
                                System.out.println("Stare modificata in " + denumireStare);
                                e.setStareProdus(denumireStare);
                            }
                        }
                    } while (!verificare);
                    break;

                case 6:
                    String denumireImprimanta, modImprimare = "";
                    alegere = 0;
                    verificare = false;
                    do {
                        System.out.print("Intorduceti denumirea imprimantei: ");
                        denumireImprimanta = sc1.nextLine();
                        for (Echipament e : echipamente) {
                            if (e instanceof Imprimanta && e.getDenumire().equals(denumireImprimanta)) {
                                verificare = true;
                                do {
                                    System.out.println("1.COLOR 2.ALB-NEGRU");

                                    try {
                                        alegere = Integer.valueOf(sc1.nextLine().trim());

                                    } catch (NumberFormatException exception) {
                                        System.out.println("Introduceti 1 sau 2");
                                    }
                                } while (alegere != 1 && alegere != 2);
                                switch (alegere) {
                                    case 1:
                                        modImprimare = "COLOR";
                                        break;
                                    case 2:
                                        modImprimare = "ALB_NEGRU";
                                        break;
                                }
                                System.out.println("Modul de imprimare s-a modificat in " + modImprimare);
                                ((Imprimanta) e).setModTiparire(modImprimare);
                            }
                        }
                    } while (!verificare);
                    break;

                case 7:
                    String denumireCopiator, formatCopiator = "";
                    alegere = 0;
                    verificare = false;
                    do {
                        System.out.print("Introduceti denumirea copiatorului: ");
                        denumireCopiator = sc1.nextLine();
                        for (Echipament e : echipamente) {
                            if (e.getDenumire().equals(denumireCopiator) && e instanceof Copiator) {
                                verificare = true;
                                do {
                                    System.out.println("1. A3  2. A4");
                                    try {
                                        alegere = Integer.valueOf(sc1.nextLine().trim());
                                    } catch (NumberFormatException exception) {
                                        System.out.println("Alegeti 1 sau 2");
                                    }
                                } while (alegere != 1 && alegere != 2);
                                switch (alegere) {
                                    case 1:
                                        formatCopiator = "A3";
                                        break;
                                    case 2:
                                        formatCopiator = "A4";
                                        break;
                                }
                                System.out.println("Formatul de copiere a fost schimbat in " + formatCopiator);
                                ((Copiator) e).setFormatCopiere(formatCopiator);
                            }
                        }

                    } while (!verificare);
                    break;

                case 8:
                    String dernumireSistemCalcul, sistemOperare = "";
                    alegere = 0;
                    verificare = false;
                    do {
                        System.out.print("Introduceti denumirea sistemului de calcul ");
                        dernumireSistemCalcul = sc1.nextLine();
                        for (Echipament e : echipamente) {
                            if (e instanceof SistemDeCalcul && e.getDenumire().equals(dernumireSistemCalcul)) {
                                verificare = true;
                                do {
                                    System.out.println("1. Windows  2. Linux");
                                    try {
                                        alegere = Integer.valueOf(sc1.nextLine().trim());
                                    } catch (NumberFormatException exception) {
                                        System.out.println("Alegeti 1 sau 2");
                                    }
                                } while (alegere != 1 && alegere != 2);
                                switch (alegere) {
                                    case 1:
                                        sistemOperare = "WINDOWS";
                                        break;
                                    case 2:
                                        sistemOperare = "LINUX";
                                        break;
                                }
                                System.out.println("Noul sistem de operare este " + sistemOperare);
                                ((SistemDeCalcul) e).setSistemOperare(sistemOperare);
                            }
                        }
                    } while (!verificare);
                    break;

                case 9:
                    for (Echipament e : echipamente) {
                        if (e.getStareProdus().equals("VANDUT")) {
                            System.out.println(e.toString());
                        }
                    }
                    break;

                case 10:
                    exit(0);
                    break;
            }
        }
    }
}
