package ui.admin.clients_registration.controller;

import model.Client;
import ui.admin.clients_registration.models.ClientTableModel;
import ui.admin.clients_registration.view.client_data.FormPanel;
import util.Const;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RegistrationController {
    private static RegistrationController ourInstance = new RegistrationController();

    private FormPanel formPanel;
    private JTable clientTable;
    private ClientTableModel clientTableModel;
    private JTextField searchTF;

    public static RegistrationController getInstance() {
        return ourInstance;
    }

    public void onSaveClick() {
        int selectedRowIndex = clientTable.getSelectedRow();

        if (formPanel.getImieTF().getText().equals("") || formPanel.getNazwiskoTF().getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    Const.Strings.NAME_AND_SURNAME_REQUIRED,
                    Const.Strings.INFORMATION,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (selectedRowIndex != -1) {
                int clientId = clientTableModel.getclientByRow(selectedRowIndex).getId();
                Client client = formPanel.getclientFromFields();
                client.setId(clientId);
                clientTableModel.editclientByRow(client, selectedRowIndex);
                clientTable.clearSelection();
                formPanel.clearForm();
            } else {
                Client client = formPanel.getclientFromFields();
                clientTableModel.addclient(client);
                formPanel.clearForm();
            }
        }
    }

    public void zapiszDaneDoPliku() {
        try {
            FileOutputStream fos = new FileOutputStream("ListaKlientow.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            List<Client> clients = clientTableModel.getClients();

            oos.writeObject(clients);
            oos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public ArrayList<Client> odczytajDaneZPliku() {
        try {
            FileInputStream fis = new FileInputStream("ListaKlientow.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            ArrayList<Client> clients = (ArrayList<Client>)ois.readObject();
            return clients;
        } catch (Exception e) {
            return null;
        }
    }

    public void onCancelClick() {
        formPanel.clearForm();
    }

    public void onSearchClickListener() {
        StringTokenizer tokenizer = new StringTokenizer(searchTF.getText());
        if (searchTF.getText().equals("")) {
            clientTableModel.resetFilter();
            clientTableModel.sortClients();
        }
        else if (tokenizer.countTokens() == 1) {
            String token = tokenizer.nextToken();
            clientTableModel.refilter(token, token);
        }
        else if (tokenizer.countTokens() == 2) {
            String imie = tokenizer.nextToken();
            String nazwisko = tokenizer.nextToken();
            clientTableModel.refilter(imie, nazwisko);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    Const.Strings.NAME_REQUIRED,
                    Const.Strings.INFORMATION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void onAddClick() {
        clientTable.clearSelection();
        formPanel.clearForm();
    }

    public void onDeleteClick() {
        int numOfRow = clientTable.getSelectedRow();
        if (numOfRow != -1) {
            clientTableModel.removeRow(numOfRow);
            formPanel.clearForm();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    Const.Strings.ROW_DELETE_REQUIRED,
                    Const.Strings.INFORMATION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void fillFormByclient(Client client) {
        formPanel.fillForm(client);
    }

    public void setClientTable(JTable clientTable) {
        this.clientTable = clientTable;
    }

    public void setClientTableModel(ClientTableModel clientTableModel) {
        this.clientTableModel = clientTableModel;
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

    public ActionListener getSearchBtnListener() {
        return new SearchBtnLiestener();
    }

    public ActionListener getDeleteBtnListener() {
        return new DeleteBtnListener();
    }

    public ListSelectionListener getTableListListener() {
        return new TableListListener();
    }

    public void setSearchTF(JTextField searchTF) {
        this.searchTF = searchTF;
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

    class SearchBtnLiestener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onSearchClickListener();
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
                Client client = clientTableModel.getclientByRow(rowIndex);
                fillFormByclient(client);
            }
        }
    }
}
