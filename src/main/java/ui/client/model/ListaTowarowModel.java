package ui.client.model;

import dao.EquipmentsDao;
import model.Equimpent;

import javax.swing.*;
import java.util.List;

public class ListaTowarowModel extends DefaultComboBoxModel<Equimpent> {
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

    public void odejmijIloscSprzetu(int selectedIndex, int ilosWybranychSztuk) {
        Equimpent equimpent = equimpentList.get(selectedIndex);
        equimpent.setIloscSztuk(equimpent.getIloscSztuk() - ilosWybranychSztuk);
    }

    public List<Equimpent> getEquimpentList() {
        return equimpentList;
    }

    public void dodajIloscSprzetu(Equimpent equimpent, int ileSztuk) {
        for (Equimpent equimpentFroList : equimpentList) {
            if (equimpent.getMarka().equals(equimpentFroList.getMarka()) &&
                    equimpent.getModel().equals(equimpentFroList.getModel())) {

                equimpentFroList.setIloscSztuk(equimpentFroList.getIloscSztuk() + ileSztuk);
            }
        }
    }
}
