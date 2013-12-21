package ui.client.model;

import dao.EquipmentsDao;
import model.CzasWypozyczenia;
import model.Equimpent;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Daniel
 */
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
