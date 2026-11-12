package lab3;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_expirare;
    static double incasari;

    public Produs(String denumire,double pret,int cantitate,LocalDate data_expirare) throws FileNotFoundException {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirare = data_expirare;
    }

    public boolean produse_expirate(){
        LocalDate data_astazi = LocalDate.now();
        if(data_expirare.isBefore(data_astazi)){
            return true;
        }else{
            return false;
        }
    }


    public boolean vanzareProdus() throws FileNotFoundException {
        int cantitate;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Cantitatea disponibila este " + this.cantitate);
            System.out.print("Introduceti cantitatea dorita ");
            cantitate = sc.nextInt();
        }while(this.cantitate < cantitate);
        incasari += (pret * cantitate);
        this.cantitate -= cantitate;
        if(this.cantitate == 0){
            return true;
        }else{
            return false;
        }
    }

    public String getDenumire(){
        return this.denumire;
    }
    public double getPret(){return this.pret;}
    public String getData(){
        String data = this.data_expirare.toString();
        return data;
    }

    @Override
    public String toString(){
        return "Denumire:" + denumire + " pret:" + pret + " cantitate:" + cantitate + " data de expirare:" + data_expirare;
    }
}
