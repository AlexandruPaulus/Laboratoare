/*Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
linie cu linie urmărind valorile variabilelor în memorie.*/

package problema1;

import java.io.PrintStream;
import java.util.Scanner;

class MainApp{
    public static void main(String[] args){
        int lungime,latime,arie,perimetru;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti lungimea ");
        lungime = scanner.nextInt();
        System.out.print("Introduceti latimea ");
        latime = scanner.nextInt();
        arie = lungime*latime;
        perimetru = 2*(lungime+latime);
        System.out.println("Aria dreptunghiului este " +arie+ "\n"+"Perimetrul dreptunghiului este "+perimetru);
    }
}

