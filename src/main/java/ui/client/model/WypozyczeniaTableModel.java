package ui.client.model;

import model.Wypozyczenie;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WypozyczeniaTableModel extends AbstractTableModel {

    private String[] naglowki = {"Nazwisko", "Marka i model sprzętu", "Ilość sztuk", "Okres wypożyczenia", "Data wypozyczenia"};
    private List<Wypozyczenie> wypozyczenia = new ArrayList<Wypozyczenie>();

    public WypozyczeniaTableModel(List<Wypozyczenie> wypozyczenia) {
        if (wypozyczenia != null) {
            this.wypozyczenia = wypozyczenia;
        }
    }

    @Override
    public int getRowCount() {
        return wypozyczenia.size();
    }

    @Override
    public int getColumnCount() {
        return naglowki.length;
    }

    @Override
    public String getColumnName(int column) {
        return naglowki[column];
    }

    public void dodajWypozyczenie(Wypozyczenie wypozyczenie) {
        this.wypozyczenia.add(wypozyczenie);
        fireTableDataChanged();
    }

    public void remove(int index) {
        wypozyczenia.remove(index);
        fireTableDataChanged();
    }

    public Wypozyczenie getSelectedRow(int index) {
        return wypozyczenia.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Wypozyczenie wypozyczenie = wypozyczenia.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return wypozyczenie.getNazwisko();
            case 1:
                return wypozyczenie.getEquimpent().getMarka() + " " + wypozyczenie.getEquimpent().getModel();
            case 2:
                return wypozyczenie.getIleSztuk();
            case 3:
                return wypozyczenie.getCzasWypozyczenia();
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                return sdf.format(wypozyczenie.getDate());
            default:
                return "";
        }
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }
}
