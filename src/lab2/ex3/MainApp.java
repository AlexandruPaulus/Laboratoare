package lab2.ex3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String []args )throws IOException {
        File fisier = new File("Laboratoare/src/lab2/ex3/text_in.txt");
        String date = "";
        try(Scanner sc = new Scanner(fisier)){

            while(sc.hasNextLine()){
                date += sc.nextLine() + "\n";
            }
        }catch(IOException e){
            System.out.println("Eroare la gasirea fisierului");
        }
        System.out.println(functie(date));

    }
    public static String functie(String sir){
        StringBuilder sb = new StringBuilder(sir);
        Scanner sc = new Scanner(System.in);
        int pozitieIns,pozitieSterg,nrCaractere;
        String subsir;

        System.out.print("Introduceti pozitia de inserare a sirului ");
        pozitieIns = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduceti sub-sirul ");
        subsir = sc.nextLine();
        sb.insert(pozitieIns, subsir);

        System.out.print("Introduceti pozitia pentru stergere a unei bucati ");
        pozitieSterg = sc.nextInt();

        System.out.print("Introduceti numarul de caractere de sters ");
        nrCaractere = sc.nextInt();

        sb.delete(pozitieSterg,nrCaractere + pozitieSterg + 1);

        return sb.toString();
    }
}
