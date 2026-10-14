package lab1.ex1;

import java.util.Scanner;
import java.io.IOException;

public class MainApp {
    static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double L,l,A,P;
        System.out.print("Introduceti lungimea ");
        L = scanner.nextDouble();
        System.out.print("Introduceti latimea ");
        l = scanner.nextDouble();
        A = L*l;
        P = 2 * (L+l);
        System.out.println("Aria este: "+A);
        System.out.println("Perimetru este: "+P);
    }
}
