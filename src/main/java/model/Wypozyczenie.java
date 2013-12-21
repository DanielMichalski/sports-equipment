package model;

public class Wypozyczenie {
    private String nazwisko;
    private Equimpent equimpent;
    private int ileSztuk;
    private CzasWypozyczenia czasWypozyczenia;

    public Wypozyczenie(String nazwisko, Equimpent equimpent, int ileSztuk, CzasWypozyczenia czasWypozyczenia) {
        this.nazwisko = nazwisko;
        this.equimpent = equimpent;
        this.ileSztuk = ileSztuk;
        this.czasWypozyczenia = czasWypozyczenia;
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
