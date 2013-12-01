package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private int id;
    private String imie;
    private String nazwisko;
    private Plec plec;
    private Zawod zawod;
    private List<Survey> surveys;

    public Client(String imie, String nazwisko, Plec plec, Zawod zawod) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.zawod = zawod;
        this.surveys = new ArrayList<Survey>();
    }

    public Client(int id, String imie, String nazwisko, Plec plec, Zawod zawod) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.zawod = zawod;
        this.surveys = new ArrayList<Survey>();
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Plec getPlec() {
        return plec;
    }

    public Zawod getZawod() {
        return zawod;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void addSurvey(Survey survey) {
        this.surveys.add(survey);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", zawod=" + zawod +
                '}';
    }
}
