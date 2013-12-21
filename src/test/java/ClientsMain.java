import dao.ClientsDao;
import model.Client;
import model.Plec;
import model.Zawod;
import ui.admin.clients_registration.view.RegistrationFrame;

import javax.swing.*;

public class ClientsMain {
    public static void main(String[] args) {
        RegistrationFrame frame = new RegistrationFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

//        checkClients();
    }

    private static void checkClients() {
        Client client1 = new Client("Tomasz", "Kowalski", "password", Plec.Mężczyzna, Zawod.pracownik_fizyczny);
        Client client2 = new Client("Tomasz", "Malinowski", "password", Plec.Mężczyzna, Zawod.pracownik_fizyczny);

        boolean check1 = ClientsDao.isClientExist(client1.getNazwisko(), client1.getHaslo());
        boolean check2 = ClientsDao.isClientExist(client2.getNazwisko(), client2.getHaslo());

        System.out.println(check1);
        System.out.println(check2);
    }
}
