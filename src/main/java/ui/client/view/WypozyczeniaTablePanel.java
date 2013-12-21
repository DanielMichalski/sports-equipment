package ui.client.view;

import ui.admin.equipment.controller.EquipmentController;
import ui.admin.equipment.models.EquipmentTableModel;
import ui.admin.equipment.view.equipment_table.TableBtnPanel;
import ui.client.model.WypozyczeniaTableModel;
import util.Const;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
public class WypozyczeniaTablePanel extends JPanel {
    private JTable rezerwacjeTabela;
    private JButton usunBtn;

    public WypozyczeniaTablePanel() {
        setUpPanel();
        initComponents();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void initComponents() {
        WypozyczeniaTableModel wypozyczeniaTableModel = new WypozyczeniaTableModel();
        rezerwacjeTabela = new JTable(wypozyczeniaTableModel);
        rezerwacjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(rezerwacjeTabela);
        add(paneWithTable, BorderLayout.CENTER);

        JPanel buttonPanl = new JPanel();
        usunBtn = new JButton(Const.ButtonLbls.BTN_DELETE);
        buttonPanl.add(usunBtn);
        add(buttonPanl, BorderLayout.SOUTH);
    }

    public JTable getRezerwacjeTabela() {
        return rezerwacjeTabela;
    }

    public JButton getUsunBtn() {
        return usunBtn;
    }
}
