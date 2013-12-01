package ui.admin.admin_choose.view;

import javax.swing.*;
import java.awt.*;

public class AdminChoosePanel extends JPanel {
    private JButton clientsBtn;
    private JButton equipmentBtn;

    public AdminChoosePanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(3, 1, 10, 20));
    }

    private void initializeComponents() {
        clientsBtn = new JButton("Zarządzanie klientami");
        equipmentBtn = new JButton("Zarządzanie sprzętem");

        add(clientsBtn);
        add(equipmentBtn);

        String lastName = System.getProperty("lastName");

        add(new JLabel("Zalogowany użytkownik: " + lastName + " - Administrator"));
    }

    public JButton getClientsBtn() {
        return clientsBtn;
    }

    public JButton getEquipmentBtn() {
        return equipmentBtn;
    }
}
