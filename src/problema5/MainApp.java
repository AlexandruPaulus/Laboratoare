/*Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
Programul va determina dacă numărul aparține șirului lui Fibonacci.*/

package problema5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {

        Random rand = new Random();
        int nr = rand.nextInt(21);
        int sub1=0,sub2=1;
        boolean verificare = false;
        while(sub1 <= nr) {
            sub2 = sub2 + sub1;
            sub1 = sub2 - sub1;
            if(sub1 == nr)
            {
                verificare = true;
                break;
            }
            else
            {
                verificare = false;
            }
        }
        if (verificare) {
            System.out.println("Numarul " + nr + " apartine sirului Fibonacci.");
        } else {
            System.out.println("Numarul " + nr + " nu apartine sirului Fibonacci.");
        }
        }
    }

