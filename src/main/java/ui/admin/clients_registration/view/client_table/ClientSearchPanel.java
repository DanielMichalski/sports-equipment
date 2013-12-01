package ui.admin.clients_registration.view.client_table;

import ui.admin.clients_registration.controller.RegistrationController;

import javax.swing.*;
import java.awt.*;

public class ClientSearchPanel extends JPanel {
    RegistrationController presenter;

    public ClientSearchPanel() {
        initComponents();
    }

    private void initComponents() {
        presenter = RegistrationController.getInstance();

        JLabel nameAndSurnameLbl = new JLabel("Imię i nazwisko");
        add(nameAndSurnameLbl);

        JTextField nameAndSurnameTF = new JTextField();
        nameAndSurnameTF.setPreferredSize(new Dimension(250, 22));
        add(nameAndSurnameTF);

        JButton searchBtn = new JButton("Szukaj");
        searchBtn.addActionListener(presenter.getSearchBtnListener());
        add(searchBtn);

        presenter.setSearchTF(nameAndSurnameTF);
    }
}
