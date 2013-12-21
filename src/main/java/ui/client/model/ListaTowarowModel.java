package ui.client.model;

import dao.EquipmentsDao;
import model.Equimpent;

import javax.swing.*;
import java.util.List;

/**
 * Author: Daniel
 */
public class ListaTowarowModel extends DefaultComboBoxModel<Equimpent>{
    List<Equimpent> equimpentList;

    public ListaTowarowModel() {
        equimpentList = EquipmentsDao.odczytajDaneZPliku();
    }

    @Override
    public int getSize() {
        return equimpentList.size();
    }

    @Override
    public Equimpent getElementAt(int index) {
        return equimpentList.get(index);
    }
}
