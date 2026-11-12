package lab4;

import java.util.Locale;

public class Echipament {

    public enum ZonaMag{
        DEPOZIT,
        RECEPTIE,
        RAFT
    }
    public enum StareProdus{
        ACHIZITIONAT,
        EXPUS,
        VANDUT
    }

    private String denumire;
    private int nr_inventar;
    private double pret;
    private ZonaMag zonaMag;
    private StareProdus stareProdus;

    public Echipament(String denumire, int nr_inventar,Double pret, ZonaMag zonaMag, StareProdus stareProdus){
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stareProdus = stareProdus;

    }
    public void setStareProdus(String stareProdus){

         this.stareProdus = Echipament.StareProdus.valueOf(stareProdus);
    }

    public String getDenumire(){
        return this.denumire;
    }

    @Override
    public String toString(){
        return "Denumire:" + denumire + ", numar inventar:" + nr_inventar + ", pret:" + pret + ", zona magazin:" + zonaMag.toString().toLowerCase() + ", stare produs:" + stareProdus.toString().toLowerCase();
    }
}
