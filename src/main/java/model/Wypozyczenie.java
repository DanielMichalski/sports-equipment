package model;

import java.io.Serializable;
import java.util.Date;

public class Wypozyczenie implements Serializable {
    private String nazwisko;
    private Equimpent equimpent;
    private int ileSztuk;
    private CzasWypozyczenia czasWypozyczenia;
    private Date date;

    public Wypozyczenie(String nazwisko, Equimpent equimpent, int ileSztuk, CzasWypozyczenia czasWypozyczenia, Date date) {
        this.nazwisko = nazwisko;
        this.equimpent = equimpent;
        this.ileSztuk = ileSztuk;
        this.czasWypozyczenia = czasWypozyczenia;
        this.date = date;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Equimpent getEquimpent() {
        return equimpent;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    public CzasWypozyczenia getCzasWypozyczenia() {
        return czasWypozyczenia;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" +
                "nazwisko='" + nazwisko + '\'' +
                ", equimpent=" + equimpent +
                ", ileSztuk=" + ileSztuk +
                ", czasWypozyczenia=" + czasWypozyczenia +
                '}';
    }
}
