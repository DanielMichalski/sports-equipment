package dao;

import model.Wypozyczenie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WypozyczeniaDao {
    public static void zapiszDaneDoPliku(List<Wypozyczenie> wypozyczenia) {
        try {
            FileOutputStream fos = new FileOutputStream("Wypozyczenia.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(wypozyczenia);
            oos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static List<Wypozyczenie> odczytajDaneZPliku() {
        List<Wypozyczenie> wypozyczenia = new ArrayList<Wypozyczenie>();

        try {
            FileInputStream fis = new FileInputStream("Wypozyczenia.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            wypozyczenia = (ArrayList<Wypozyczenie>) ois.readObject();
            return wypozyczenia;
        } catch (Exception e) {
            return wypozyczenia;
        }
    }
}