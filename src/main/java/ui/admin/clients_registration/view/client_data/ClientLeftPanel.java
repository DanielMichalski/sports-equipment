package ui.admin.clients_registration.view.client_data;

import javax.swing.*;
import java.awt.*;

public class ClientLeftPanel extends JPanel {

    public ClientLeftPanel() {
        setUpPanel();
        initComponents();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        FormPanel formPanel = new FormPanel();
        add(formPanel, BorderLayout.CENTER);

        DataButtonPanl buttonPanel = new DataButtonPanl();
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
