package ui.admin.equipment.view.euqipment_form;

import ui.admin.equipment.controller.EquipmentController;
import util.Const;

import javax.swing.*;

public class DataButtonPanl extends JPanel {
    EquipmentController presenter;

    public DataButtonPanl() {
        initComponents();
    }

    private void initComponents() {
        presenter = EquipmentController.getInstance();

        JButton zapiszBtn = new JButton(Const.ButtonLbls.BTN_SAVE);
        zapiszBtn.addActionListener(presenter.getSaveBtnListener());
        add(zapiszBtn);

        JButton anulujBtn = new JButton(Const.ButtonLbls.BTN_CANCEL);
        anulujBtn.addActionListener(presenter.getCancelBtnListener());
        add(anulujBtn);
    }
}
