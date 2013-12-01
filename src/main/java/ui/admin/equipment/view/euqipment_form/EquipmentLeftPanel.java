package ui.admin.equipment.view.euqipment_form;

import javax.swing.*;
import java.awt.*;

public class EquipmentLeftPanel extends JPanel {

    public EquipmentLeftPanel() {
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
