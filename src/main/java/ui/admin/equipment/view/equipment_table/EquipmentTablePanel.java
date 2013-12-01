package ui.admin.equipment.view.equipment_table;

import ui.admin.equipment.controller.EquipmentController;
import ui.admin.equipment.models.EquipmentTableModel;

import javax.swing.*;
import java.awt.*;

public class EquipmentTablePanel extends JPanel {
    EquipmentController presenter = EquipmentController.getInstance();

    private JTable clientTable;
    private EquipmentTableModel clientTableModel;

    public EquipmentTablePanel() {
        setUpPanel();
        initComponents();
        setBackground(Color.black);
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        clientTableModel = new EquipmentTableModel(EquipmentController.getInstance().odczytajDaneZPliku());
        clientTable = new JTable(clientTableModel);
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel listSelectionModel = clientTable.getSelectionModel();
        clientTable.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(presenter.getTableListListener());

        JScrollPane paneWithTable = new JScrollPane(clientTable);
        add(paneWithTable, BorderLayout.CENTER);

        TableBtnPanel btnPanel = new TableBtnPanel();
        add(btnPanel, BorderLayout.SOUTH);

        presenter.setEquipmentTableModel(clientTableModel);
        presenter.setClientTable(clientTable);
    }
}
