package dao;

import model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDao {
    public static void zapiszDaneDoPliku(List<Client> clients) {
        try {
            FileOutputStream fos = new FileOutputStream("ListaKlientow.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(clients);
            oos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static List<Client> odczytajDaneZPliku() {
        List<Client> clients = new ArrayList<Client>();

        try {
            FileInputStream fis = new FileInputStream("ListaKlientow.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            clients = (ArrayList<Client>) ois.readObject();
            return clients;
        } catch (Exception e) {
            return clients;
        }
    }

    public static boolean isClientExist(String nazwisko, String haslo) {
        List<Client> clients = odczytajDaneZPliku();

        for (Client clientFromFile : clients) {
            if (nazwisko.equals(clientFromFile.getNazwisko()) &&
                    haslo.equals(clientFromFile.getHaslo())) {
                return true;
            }
        }

        return false;
    }
}
