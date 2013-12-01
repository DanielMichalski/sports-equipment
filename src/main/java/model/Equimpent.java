package model;

import java.io.Serializable;


public class Equimpent implements Serializable {
    private int id;
    String marka;
    String model;
    Przeznaczenie przeznaczenie;
    TypSprzetu okresWypozyczenia;

    public Equimpent(String marka, String model, Przeznaczenie przeznaczenie, TypSprzetu okresWypozyczenia) {
        this.marka = marka;
        this.model = model;
        this.przeznaczenie = przeznaczenie;
        this.okresWypozyczenia = okresWypozyczenia;
    }

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public Przeznaczenie getPrzeznaczenie() {
        return przeznaczenie;
    }

    public TypSprzetu getOkresWypozyczenia() {
        return okresWypozyczenia;
    }

    public void setId(int id) {
        this.id = id;
    }
}
