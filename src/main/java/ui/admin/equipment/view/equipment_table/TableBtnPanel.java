package ui.admin.equipment.view.equipment_table;

import ui.admin.equipment.controller.EquipmentController;
import util.Const;

import javax.swing.*;

public class TableBtnPanel extends JPanel {
    EquipmentController presenter;

    public TableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        presenter = EquipmentController.getInstance();

        JButton usunBtn = new JButton(Const.ButtonLbls.BTN_DELETE);
        usunBtn.addActionListener(presenter.getDeleteBtnListener());
        add(usunBtn);
    }
}
