package ui.client.model;

import model.CzasWypozyczenia;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class CzasWypozyczeniaModel extends DefaultComboBoxModel<CzasWypozyczenia> {
    List<CzasWypozyczenia> czasWypozyczeniaList;

    public CzasWypozyczeniaModel() {
        czasWypozyczeniaList = Arrays.asList(CzasWypozyczenia.values());
    }

    @Override
    public int getSize() {
        return czasWypozyczeniaList.size();
    }

    @Override
    public CzasWypozyczenia getElementAt(int index) {
        return czasWypozyczeniaList.get(index);
    }
}
