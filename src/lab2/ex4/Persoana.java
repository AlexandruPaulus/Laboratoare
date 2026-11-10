package lab2.ex4;

import java.time.LocalDate;

public class Persoana {
    private String nume;
    private String CNP;
    private int varsta;

    public Persoana(String nume,String CNP, int varsta){
        this.CNP = CNP;
        this.nume = nume;
        this.varsta = varsta;
    }

    public boolean verificare(){
        if(CNP == null || CNP.length() != 13){
            return false;
        }

        for(char c : CNP.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        char c = CNP.charAt(0);
        if(c != '1' && c != '2' && c != '5' && c != '6'){
            return false;
        }

        int[] constante = {2,7,9,1,4,6,3,5,8,2,7,9};
        int suma = 0;
        for(int i=0;i<12;i++){
            suma  += constante[i] * (CNP.charAt(i) - '0');
        }
        int rest = (suma % 11);

        if(rest == 10){
            rest = 1;
        }
        int cifra = CNP.charAt(12) - '0';
        if(rest != cifra){
            return false;
        }
            return true;
    }

    public void varsta(){
        LocalDate dataAzi = LocalDate.now();
        int an = dataAzi.getYear();
        int luna = dataAzi.getMonthValue();
        int zi = dataAzi.getDayOfWeek().getValue();
        int an_nastere = CNP.charAt(2) - '0';
        switch (CNP.charAt(0)){
            case '1':
            case '2':
                an_nastere += 1900;
                break;
            case '5':
            case '6':
                an_nastere += 2000;
                break;
            case '4':
            case '3':
                an_nastere += 1800;
                break;
            default:
            System.out.println("Cifra invalida");
            break;
        }
        int luna_nastere = Integer.parseInt(CNP.substring(3,4));
        int zi_nastere = Integer.parseInt(CNP.substring(1,2));
        varsta = an - an_nastere;
        if(luna < luna_nastere || (luna == luna_nastere && zi < zi_nastere)){
            varsta --;
        }
    }
        @Override
        public String toString(){
            System.out.println("");
            return "Nume: " + nume + " varsta: " + varsta + " CNP: " + CNP;
        }

    public void setCNP(String CNP){
        this.CNP = CNP;
    }

}
