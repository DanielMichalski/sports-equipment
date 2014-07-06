package dao;

import model.Equimpent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentsDao {
    public static void zapiszDaneDoPliku(List<Equimpent> equimpents) {
        try {
            FileOutputStream fos = new FileOutputStream("ListaTowarow.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(equimpents);
            oos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static List<Equimpent> odczytajDaneZPliku() {
        List<Equimpent> equimpents = new ArrayList<Equimpent>();

        try {
            FileInputStream fis = new FileInputStream("ListaTowarow.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            equimpents = (ArrayList<Equimpent>) ois.readObject();
            return equimpents;
        } catch (Exception e) {
            return equimpents;
        }
    }
}
