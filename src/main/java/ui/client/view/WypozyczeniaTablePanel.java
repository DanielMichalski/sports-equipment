package ui.client.view;

import ui.client.controller.WypozyczeniaPresenter;
import ui.client.model.WypozyczeniaTableModel;
import util.Const;

import javax.swing.*;
import java.awt.*;

public class WypozyczeniaTablePanel extends JPanel {
    private WypozyczeniaPresenter presenter;

    private JTable rezerwacjeTabela;
    private JButton usunBtn;

    public WypozyczeniaTablePanel(WypozyczeniaPresenter presenter) {
        this.presenter = presenter;

        setUpPanel();
        initComponents();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void initComponents() {
        WypozyczeniaTableModel wypozyczeniaTableModel = new WypozyczeniaTableModel(presenter.odczytajDaneZPliku());
        rezerwacjeTabela = new JTable(wypozyczeniaTableModel);
        rezerwacjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(rezerwacjeTabela);
        add(paneWithTable, BorderLayout.CENTER);

        JPanel buttonPanl = new JPanel();
        usunBtn = new JButton(Const.ButtonLbls.BTN_DELETE);
        buttonPanl.add(usunBtn);
        add(buttonPanl, BorderLayout.SOUTH);
    }

    public JTable getRezerwacjeTabela() {
        return rezerwacjeTabela;
    }

    public JButton getUsunBtn() {
        return usunBtn;
    }
}
