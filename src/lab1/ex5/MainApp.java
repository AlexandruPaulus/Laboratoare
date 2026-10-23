package lab1.ex5;

import java.io.IOException;
import java.util.Random;

public class MainApp {
    public static void main(String[] args)throws IOException {
        Random rand = new Random();
        int numar = rand.nextInt(20) + 1;

        int a = 0;
        int b = 0;

        while(a < numar){
            int urmator = a + b;
            a = b;
            b = urmator;
        }

        if (a == numar) {
            System.out.println(numar + " FACE parte din șirul Fibonacci.");
        } else {
            System.out.println(numar + " NU face parte din șirul Fibonacci.");
        }
    }
}
