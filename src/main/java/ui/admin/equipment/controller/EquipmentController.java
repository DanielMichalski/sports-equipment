package ui.admin.equipment.controller;

import model.Client;
import model.Equimpent;
import ui.admin.equipment.models.EquipmentTableModel;
import ui.admin.equipment.view.euqipment_form.FormPanel;
import util.Const;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentController {
    private static EquipmentController ourInstance = new EquipmentController();

    private FormPanel formPanel;
    private JTable clientTable;
    private EquipmentTableModel equipmentTableModel;

    public static EquipmentController getInstance() {
        return ourInstance;
    }

    public void onSaveClick() {
        int selectedRowIndex = clientTable.getSelectedRow();

        if (formPanel.getMarkaTF().getText().equals("") || formPanel.getModelTF().getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Marka i model muszą być uzupełnione.",
                    Const.Strings.INFORMATION,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (selectedRowIndex != -1) {
                int clientId = equipmentTableModel.getEquipmentByRow(selectedRowIndex).getId();
                Equimpent client = formPanel.getequipmentFromFields();
                client.setId(clientId);
                equipmentTableModel.editclientByRow(client, selectedRowIndex);
                clientTable.clearSelection();
                formPanel.clearForm();
            } else {
                Equimpent equimpent = formPanel.getequipmentFromFields();
                equipmentTableModel.addEquipment(equimpent);
                formPanel.clearForm();
            }
        }
    }

    public void zapiszDaneDoPliku() {
        try {
            FileOutputStream fos = new FileOutputStream("ListaTowarow.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            List<Equimpent> equimpents = equipmentTableModel.getEquimpents();

            oos.writeObject(equimpents);
            oos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public ArrayList<Equimpent> odczytajDaneZPliku() {
        try {
            FileInputStream fis = new FileInputStream("ListaTowarow.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            ArrayList<Equimpent> equimpents = (ArrayList<Equimpent>)ois.readObject();
            return equimpents;
        } catch (Exception e) {
            return null;
        }
    }

    public void onCancelClick() {
        formPanel.clearForm();
    }

    public void onAddClick() {
        clientTable.clearSelection();
        formPanel.clearForm();
    }

    public void onDeleteClick() {
        int numOfRow = clientTable.getSelectedRow();
        if (numOfRow != -1) {
            equipmentTableModel.removeRow(numOfRow);
            formPanel.clearForm();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    Const.Strings.ROW_DELETE_REQUIRED,
                    Const.Strings.INFORMATION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void fillFormByclient(Equimpent equimpent) {
        formPanel.fillForm(equimpent);
    }

    public void setClientTable(JTable clientTable) {
        this.clientTable = clientTable;
    }

    public void setEquipmentTableModel(EquipmentTableModel equipmentTableModel) {
        this.equipmentTableModel = equipmentTableModel;
    }

    public void setFormPanel(FormPanel formPanel) {
        this.formPanel = formPanel;
    }

    public ActionListener getSaveBtnListener() {
        return new SaveBtnListener();
    }

    public ActionListener getCancelBtnListener() {
        return new CancelBtnListener();
    }

    public ActionListener getDeleteBtnListener() {
        return new DeleteBtnListener();
    }

    public ListSelectionListener getTableListListener() {
        return new TableListListener();
    }

    class SaveBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onSaveClick();
        }
    }

    class CancelBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onCancelClick();
        }
    }

    class AddBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onAddClick();
        }
    }

    class DeleteBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onDeleteClick();
        }
    }

    class TableListListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            int rowIndex = clientTable.getSelectedRow();

            if (rowIndex >= 0) {
                Equimpent equimpent = equipmentTableModel.getEquipmentByRow(rowIndex);
                fillFormByclient(equimpent);
            }
        }
    }
}
