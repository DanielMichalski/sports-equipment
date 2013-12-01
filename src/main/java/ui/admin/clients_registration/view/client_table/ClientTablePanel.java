package ui.admin.clients_registration.view.client_table;

import ui.admin.clients_registration.controller.RegistrationController;
import ui.admin.clients_registration.models.ClientTableModel;

import javax.swing.*;
import java.awt.*;

public class ClientTablePanel extends JPanel {
    RegistrationController presenter = RegistrationController.getInstance();

    private JTable clientTable;
    private ClientTableModel clientTableModel;

    public ClientTablePanel() {
        setUpPanel();
        initComponents();
        setBackground(Color.black);
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        clientTableModel = new ClientTableModel(presenter.odczytajDaneZPliku());
        clientTable = new JTable(clientTableModel);
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel listSelectionModel = clientTable.getSelectionModel();
        clientTable.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(presenter.getTableListListener());

        ClientSearchPanel clientSearchPanel = new ClientSearchPanel();
        add(clientSearchPanel, BorderLayout.NORTH);

        JScrollPane paneWithTable = new JScrollPane(clientTable);
        add(paneWithTable, BorderLayout.CENTER);

        TableBtnPanel btnPanel = new TableBtnPanel();
        add(btnPanel, BorderLayout.SOUTH);

        presenter.setClientTableModel(clientTableModel);
        presenter.setClientTable(clientTable);
    }
}
