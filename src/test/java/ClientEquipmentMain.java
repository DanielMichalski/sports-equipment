import ui.client.view.WypozyczeniaFrame;

import javax.swing.*;

public class ClientEquipmentMain {
    public static void main(String[] args) {
        WypozyczeniaFrame wypozyczeniaFrame = new WypozyczeniaFrame("Kowalski");
        wypozyczeniaFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        wypozyczeniaFrame.setVisible(true);
    }
}
