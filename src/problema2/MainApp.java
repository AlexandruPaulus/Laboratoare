/*Să se scrie un program care citește un set de numerele din fișierul de intrare in.txt, care
conține câte un număr pe un rând, având valorile din figura 18. Programul va determina suma
lor, media aritmetică, valoarea minimă, valoarea maximă, va afișa aceste valori pe ecran și le
va scrie în fișierul de ieșire out.txt. Media aritmetică va fi afișată ca un număr real.*/
package problema2;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)throws IOException {
        int suma = 0, val_minima = 999, val_maxima = 0, val_citita,nr_numere=0;
        double medie_aritmetica;
       Scanner sc = new Scanner(new File("src/problema2/in.txt"));
       while(sc.hasNext()){
           if(sc.hasNextInt()){
        val_citita = sc.nextInt();
        suma += val_citita;
        if(val_citita<val_minima){

            val_minima = val_citita;
        }
        if(val_citita>val_maxima){
            val_maxima = val_citita;
        }
           }
           else{
               sc.next();
           }
       }
        sc.close();
        Writer writer = new FileWriter("src/problema2/out.txt");
        writer.write("Suma:"+suma+"\n");
        writer.write("Val_minima:"+val_minima+"\n");
        writer.write("Val_maxima:"+val_maxima+"\n");
        writer.close();
    }
}