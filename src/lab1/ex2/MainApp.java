package lab1.ex2;

import java.io.*;
import java.util.Scanner;


public class MainApp {
    static void main(String args[]) throws IOException{

        int suma = 0,mediaAritmetica = 0,valMin,valMax;
        File fisier = new File("Laboratoare/src/lab1/ex2/in.txt");
        int [] vector = new int[6];
        int i=0;
        try(Scanner scanner = new Scanner(fisier)){
            while(scanner.hasNextInt()){
                vector[i] = scanner.nextInt();
                i++;
            }
        }catch(FileNotFoundException e){
            System.out.println("Fisier negasit");
        }

        valMin = vector[0];
        valMax = vector[0];

        for(int j = 0; j < vector.length;j++){
            suma += vector[j];
            if(vector[j] < valMin){
                valMin = vector[j];
            }
            if(vector[j] > valMax){
                valMax = vector[j];
            }
        }

        mediaAritmetica = suma / vector.length;

        System.out.println("Suma este: " + suma);
        System.out.println("Media aritmetica este: " + mediaAritmetica);
        System.out.println("Valoarea minima este: " + valMin);
        System.out.println("Valoarea maxima este: " + valMax);

        File fisierIesire = new File("Laboratoare/src/lab1/ex2/out.txt");

        try(PrintStream writer = new PrintStream(fisierIesire)){
            writer.println("Suma: " + suma);
            writer.println("Media aritmetica: " + mediaAritmetica);
            writer.println("Val min: " + valMin);
            writer.println("Val max: " + valMax);
        }catch(FileNotFoundException e){
            System.out.println("Fisieru nu s-a gasit");

        }

    }
}
