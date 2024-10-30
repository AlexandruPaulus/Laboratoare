/*Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător.*/

package problema3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numarul ");
        int numar = scanner.nextInt();
        boolean verificare = false;
        for (int i = 2; i < numar; i++) {
            if ((numar % i) == 0) {
                System.out.println(i + " este divizorul lui " + numar);
                verificare = true;
            }
        }
            if(verificare==false){

                System.out.println("Numarul este prim");
            }

    }
}
