package lab1.ex4;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
   public static void main(String[] args)throws IOException {

       int a = 0;
       int b = 0;
       Random rand = new Random();
       a = rand.nextInt(30) + 1;
       b = rand.nextInt(30) + 1;

       int x = a;
       int y = b;

       while (y != 0) {
           int rest = x % y;
           x = y;
           y = rest;
       }

       int cmmdc = x;

       System.out.println("CMMDC(" + a + ", " + b + ") = " + cmmdc);
    }
}
