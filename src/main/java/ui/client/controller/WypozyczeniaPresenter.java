package ui.client.controller;

import dao.EquipmentsDao;
import dao.WypozyczeniaDao;
import model.CzasWypozyczenia;
import model.Equimpent;
import model.Wypozyczenie;
import ui.client.model.CzasWypozyczeniaModel;
import ui.client.model.ListaTowarowModel;
import ui.client.model.WypozyczeniaTableModel;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;

public class WypozyczeniaPresenter {
    private JComboBox<Equimpent> equimpentCB;
    private JComboBox<CzasWypozyczenia> czasWypozyczeniaCB;
    private JSpinner iloscSztukSpinner;
    private JTable rezerwacjeTabela;
    private String nazwisko;

    public WypozyczeniaPresenter(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void zapiszDaneDoPliku() {
        WypozyczeniaTableModel model = (WypozyczeniaTableModel) rezerwacjeTabela.getModel();
        List<Wypozyczenie> wypozyczenia = model.getWypozyczenia();
        WypozyczeniaDao.zapiszDaneDoPliku(wypozyczenia);

        ListaTowarowModel model1 = (ListaTowarowModel) equimpentCB.getModel();
        EquipmentsDao.zapiszDaneDoPliku(model1.getEquimpentList());
    }

    public List<Wypozyczenie> odczytajDaneZPliku() {
        return WypozyczeniaDao.odczytajDaneZPliku();
    }

    public WindowListener getWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                zapiszDaneDoPliku();
            }
        };
    }

    class WypozyczBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (equimpentCB.getSelectedIndex() != -1) {
                if (czasWypozyczeniaCB.getSelectedIndex() != -1) {

                    ListaTowarowModel equimpentCBModel =
                            (ListaTowarowModel) equimpentCB.getModel();
                    Equimpent equipment =
                            equimpentCBModel.getElementAt(equimpentCB.getSelectedIndex());

                    CzasWypozyczeniaModel czasWypozyczeniaModel =
                            (CzasWypozyczeniaModel) czasWypozyczeniaCB.getModel();
                    CzasWypozyczenia czasWypozyczenia =
                            czasWypozyczeniaModel.getElementAt(czasWypozyczeniaCB.getSelectedIndex());

                    int ilosWybranychSztuk =
                            Integer.parseInt(iloscSztukSpinner.getValue().toString());

                    if (ilosWybranychSztuk <= 0 || ilosWybranychSztuk > equipment.getIloscSztuk()) {
                        pokazInfoNieprawidlowaIloscSztuk();
                    } else {
                        WypozyczeniaTableModel model =
                                (WypozyczeniaTableModel) rezerwacjeTabela.getModel();

                        Wypozyczenie wypozyczenie =
                                new Wypozyczenie(nazwisko, equipment, ilosWybranychSztuk, czasWypozyczenia, new Date());

                        model.dodajWypozyczenie(wypozyczenie);
                        equimpentCBModel.odejmijIloscSprzetu(equimpentCB.getSelectedIndex(), ilosWybranychSztuk);
                        clearForm();
                    }
                } else {
                    pokazInfoNieWybranoCzasu();
                }

            } else {
                pokazInfoNieWybranoSprzetu();
            }

        }
    }

    private void clearForm() {
        equimpentCB.setSelectedIndex(0);
        czasWypozyczeniaCB.setSelectedIndex(0);
        iloscSztukSpinner.setValue(0);
    }

    private void pokazInfoNieWybranoCzasu() {
        JOptionPane.showMessageDialog(
                null,
                "Nie wybrano czasu wypozyczenia",
                "Informacja",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void pokazInfoNieWybranoSprzetu() {
        JOptionPane.showMessageDialog(
                null,
                "Nie wybrano sprzętu",
                "Informacja",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void pokazInfoNieprawidlowaIloscSztuk() {
        JOptionPane.showMessageDialog(
                null,
                "Wybrana ilość sztuk jest nieprawidłowa",
                "Informacja",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showInfoNoRowSelected() {
        JOptionPane.showMessageDialog(
                null,
                "Wybierz wiersz, który chcesz usunąć",
                "Informacja",
                JOptionPane.INFORMATION_MESSAGE);
    }

    class UsunBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = rezerwacjeTabela.getSelectedRow();

            if (selectedRow > -1) {
                WypozyczeniaTableModel model = (WypozyczeniaTableModel) rezerwacjeTabela.getModel();
                Wypozyczenie wypozyczenie = model.getSelectedRow(selectedRow);
                model.remove(selectedRow);

                ListaTowarowModel equimpentCBModel = (ListaTowarowModel) equimpentCB.getModel();
                equimpentCBModel.dodajIloscSprzetu(wypozyczenie.getEquimpent(), wypozyczenie.getIleSztuk());
            } else {
                showInfoNoRowSelected();
            }
        }
    }

    public void setCzasWypozyczeniaCB(JComboBox<CzasWypozyczenia> czasWypozyczeniaCB) {
        this.czasWypozyczeniaCB = czasWypozyczeniaCB;
    }

    public void setIloscSztukSpinner(JSpinner iloscSztukSpinner) {
        this.iloscSztukSpinner = iloscSztukSpinner;
    }

    public void setWypozyczButton(JButton wypozyczButton) {
        wypozyczButton.addActionListener(new WypozyczBtnListener());
    }

    public void setRezerwacjeTabela(JTable rezerwacjeTabela) {
        this.rezerwacjeTabela = rezerwacjeTabela;
    }

    public void setEquimpentCB(JComboBox<Equimpent> equimpentCB) {
        this.equimpentCB = equimpentCB;
    }

    public void setUsunBtn(JButton usunBtn) {
        usunBtn.addActionListener(new UsunBtnListener());
    }
}
