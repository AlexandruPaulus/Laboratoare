package lab2.ex1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

    public class MainApp {
        public static void main(String[] args)throws IOException {
            File fisier = new File("Laboratoare/src/lab2/ex1/judete_in.txt");
            Scanner sc = new Scanner(fisier);
            String[] judete = new String[20];
            int i = 0;
            while(sc.hasNextLine()){
                judete[i] = sc.nextLine();
                i++;
            }
            Arrays.sort(judete);
            for(i = 0; i<20;i++){
                System.out.println(judete[i]);
            }

        }
    }



