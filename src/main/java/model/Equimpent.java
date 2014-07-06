package model;

import java.io.Serializable;


public class Equimpent implements Serializable {
    private int id;
    String marka;
    String model;
    Przeznaczenie przeznaczenie;
    TypSprzetu typSprzetu;
    int iloscSztuk;

    public Equimpent(String marka, String model, Przeznaczenie przeznaczenie, TypSprzetu typSprzetu, int iloscSztuk) {
        this.marka = marka;
        this.model = model;
        this.przeznaczenie = przeznaczenie;
        this.typSprzetu = typSprzetu;
        this.iloscSztuk = iloscSztuk;
    }

    public void setId(int id) {
        this.id = id;
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

    public TypSprzetu getTypSprzetu() {
        return typSprzetu;
    }

    public int getIloscSztuk() {
        return iloscSztuk;
    }

    public void setIloscSztuk(int iloscSztuk) {
        this.iloscSztuk = iloscSztuk;
    }

    @Override
    public String toString() {
        return marka + " " +
                model + ", " +
                "ilość dostępnych sztuk: " + iloscSztuk;
    }
}
