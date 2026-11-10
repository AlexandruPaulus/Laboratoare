package lab2.ex2;

import java.util.Random;

public class Vers {
    private String sir;

    Vers(String sir){
        this.sir = sir;
    }

    public String getVers(){
        return sir;
    }
    public int nr_cuv(){
        if(sir == null || sir.isBlank()){
            return 0;
        }
        int nr_cuv = sir.trim().split("\\s+").length;
        return nr_cuv;
    }

    public int nr_voc(){
        int nr_voc = 0;
        for (char c : sir.toCharArray()){
            c = Character.toUpperCase(c);
            if(c == 'A'|| c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Ă' || c == 'Â' || c == 'Î'){
                nr_voc ++;
            }
        }
        if(nr_voc != 0){
            return nr_voc;
        }else{
            return 0;
        }

    }

    public String steluta(String cuvinte){
        if (sir == null || cuvinte == null || cuvinte.isBlank()) {
            return "";
        }

        // 2. Curățăm spațiile și semnele de punctuație doar de la finalul versului ($)
        String versCuratat = sir.trim().replaceAll("[.,!?;:]+$", "");
        String cautat = cuvinte.trim();

        if (versCuratat.toLowerCase().endsWith(cautat.toLowerCase())) {
            return " *";
        } else {
            return "";
        }
    }

    public String randMajuscule(){
        Random random  = new Random();
        double nr = random.nextDouble(0,1);
        if(nr < 0.1){
            return sir.toUpperCase();
        }
        else{
            return sir;
        }
    }


}
