/*Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();*/
package problema4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        int nr1=0,nr2=0;
        Random rand = new Random();
        nr1 = rand.nextInt(30);
        nr2 = rand.nextInt(30);
        System.out.println("nr1 = " + nr1+", nr2 = " + nr2);
        System.out.println("Cel mai mic divizor comun:"+CMMDC(nr1,nr2));
    }
    public static int CMMDC(int a,int b){
        while(a!=b){
            if(a<b){
                b = b-a;
            }
            else{
                a = a-b;
            }
        }
        return a;
    }
}
