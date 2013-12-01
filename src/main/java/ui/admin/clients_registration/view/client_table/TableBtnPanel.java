package ui.admin.clients_registration.view.client_table;

import ui.admin.clients_registration.controller.RegistrationController;
import util.Const;

import javax.swing.*;

public class TableBtnPanel extends JPanel {
    RegistrationController presenter;

    public TableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        presenter = RegistrationController.getInstance();

        JButton usunBtn = new JButton(Const.ButtonLbls.BTN_DELETE);
        usunBtn.addActionListener(presenter.getDeleteBtnListener());
        add(usunBtn);
    }
}
