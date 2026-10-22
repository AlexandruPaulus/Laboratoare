package lab1.ex3;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
   public static void main(String [] args) throws IOException {
        int numar = 0;
        boolean verificare = true;
        Scanner sc  = new Scanner(System.in);
        System.out.print("Introduceti numarul ");
        numar = sc.nextInt();
        if(numar < 2){
            verificare = false;
        }
        for (int i=2 ; i < numar; i ++){
            if((numar % i) == 0){
                System.out.println(i);
                verificare = false;
            }
        }
        if(verificare){
            System.out.println("Este prim");
        }else{
            System.out.println("Nu este prim");
        }
    }
}
