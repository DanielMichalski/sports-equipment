package ui.client.model;

import model.Wypozyczenie;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class WypozyczeniaTableModel extends AbstractTableModel {

    private String[] naglowki = {"Nazwisko", "Marka i model sprzętu", "Ilość sztuk", "Okres wypożyczenia"};
    private List<Wypozyczenie> wypozyczenia = new ArrayList<Wypozyczenie>();

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
            default:
                return "";
        }
    }
}
