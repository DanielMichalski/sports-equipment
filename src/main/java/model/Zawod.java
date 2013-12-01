package model;

public enum Zawod {
    student("Student"),
    pracownik_fizyczny("Pracownik fizyczny"),
    pracownik_umysłowy("Pracownik umysłowy");

    private Zawod(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getNameToDB() {
        return name();
    }

    private String name;
}
