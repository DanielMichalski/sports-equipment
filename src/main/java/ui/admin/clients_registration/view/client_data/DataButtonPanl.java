package ui.admin.clients_registration.view.client_data;

import ui.admin.clients_registration.controller.RegistrationController;
import util.Const;

import javax.swing.*;

public class DataButtonPanl extends JPanel {
    RegistrationController presenter;

    public DataButtonPanl() {
        initComponents();
    }

    private void initComponents() {
        presenter = RegistrationController.getInstance();

        JButton zapiszBtn = new JButton(Const.ButtonLbls.BTN_SAVE);
        zapiszBtn.addActionListener(presenter.getSaveBtnListener());
        add(zapiszBtn);

        JButton anulujBtn = new JButton(Const.ButtonLbls.BTN_CANCEL);
        anulujBtn.addActionListener(presenter.getCancelBtnListener());
        add(anulujBtn);
    }
}
