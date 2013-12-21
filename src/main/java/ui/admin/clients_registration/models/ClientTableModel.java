package ui.admin.clients_registration.models;

import model.Client;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"Imię i nazwisko", "Hasło", "Płeć", "Zawód"};
    private List<Client> clients;
    private List<Client> filteredClients;

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public ClientTableModel(List<Client> clients) {
        super();
        if (clients != null) {
            this.clients = clients;
            this.filteredClients = new ArrayList<Client>();
            refilter();

            System.out.println(clients);
        } else {
            this.clients = new ArrayList<Client>();
            this.filteredClients = new ArrayList<Client>();
        }
        sortClients();
    }

    @Override
    public int getRowCount() {
        return filteredClients.size();
    }

    public void addclient(Client client) {
        clients.add(client);
        sortClients();
        refilter();
    }

    public void sortClients() {
        Comparator<Client> comparator = new Comparator<Client>() {
            @Override
            public int compare(Client pat1, Client pat2) {
                return pat1.getImie().compareToIgnoreCase(pat2.getImie());
            }
        };

        Collections.sort(clients, comparator);
        Collections.sort(filteredClients, comparator);
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = filteredClients.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getImie() + " " + client.getNazwisko();
            case 1:
                return client.getHaslo();
            case 2:
                return client.getPlec().toString().charAt(0);
            case 3:
                return client.getZawod();
            default:
                return "";
        }

    }

    public Client getclientByRow(int rowIndex) {
        return filteredClients.get(rowIndex);
    }

    public void editclientByRow(Client newclient, int rowIndex) {
        clients.set(rowIndex, newclient);
        refilter();
        sortClients();
        fireTableDataChanged();
    }

    public void removeRow(int row) {
        clients.remove(row);
        filteredClients.remove(row);
        sortClients();
        fireTableRowsDeleted(row, row);
    }

    private void refilter() {
        filteredClients.clear();
        for (Client client : clients)
            filteredClients.add(client);
        fireTableDataChanged();
    }

    public void refilter(String imie, String nazwisko) {
        filteredClients.clear();

        for (Client client : clients) {

            if (client.getImie().toLowerCase().contains(imie.toLowerCase())
                    || client.getNazwisko().toLowerCase().contains(nazwisko.toLowerCase()))
                filteredClients.add(client);
        }

        fireTableDataChanged();
    }

    public void resetFilter() {
        filteredClients.clear();
        for (Client client : clients)
            filteredClients.add(client);
        fireTableDataChanged();
    }

    public List<Client> getClients() {
        return clients;
    }
}
