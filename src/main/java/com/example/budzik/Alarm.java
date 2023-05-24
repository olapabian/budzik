package com.example.budzik;

public class Alarm {
    int Godzina;
    int Minuta;
    String dniTygodnia="";
    boolean czyPowtarzac;
    double Glosnosc;
    String Nazwa;
    public Alarm(int godzina, int minuta, String dniTygodnia, boolean czyPowtarzac, double glosnosc, String nazwa) {
        Godzina = godzina;
        Minuta = minuta;
        this.dniTygodnia=dniTygodnia;
        this.czyPowtarzac = czyPowtarzac;
        Glosnosc = glosnosc;
        Nazwa = nazwa;
    }
    @Override
    public String toString() {
        return
                  Godzina +
                ":" + Minuta +
                " " + dniTygodnia + '\'' +
                " powtarzanie: " + czyPowtarzac +
                " Glosnosc: " + Glosnosc +
                " Nazwa:" + Nazwa + '\''
                ;
    }

    public Alarm() {
    }

    public int getGodzina() {
        return Godzina;
    }

    public void setGodzina(int godzina) {
        Godzina = godzina;
    }

    public int getMinuta() {
        return Minuta;
    }

    public void setMinuta(int minuta) {
        Minuta = minuta;
    }

    public boolean isCzyPowtarzac() {
        return czyPowtarzac;
    }

    public void setCzyPowtarzac(boolean czyPowtarzac) {
        this.czyPowtarzac = czyPowtarzac;
    }

    public double getGlosnosc() {
        return Glosnosc;
    }

    public void setGlosnosc(int glosnosc) {
        Glosnosc = glosnosc;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }
}
