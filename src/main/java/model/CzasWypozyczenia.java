package model;

/**
 * Author: Daniel
 */
public enum CzasWypozyczenia {
    do24godzin("Poniżej 24 godzin"),
    od24do48godzin("Od 24 do 48 godzin"),
    powyzej48godzin("Powyżej 48 godzin");

    private String name;

    private CzasWypozyczenia(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
