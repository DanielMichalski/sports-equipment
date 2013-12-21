package ui.client.view;

import ui.client.controller.WypozyczeniaPresenter;
import util.Const;
import util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Author: Daniel
 */
public class WypozyczeniaFrame extends JDialog {
    public static final int DEFAULT_WIDTH = 750;
    public static final int DEFAULT_HEIGHT = 320;

    private String nazwisko;

    public WypozyczeniaFrame(String nazwisko) {
        this.nazwisko = nazwisko;

        setUpFrame();
        initComponents();
        setJMenuBar(createMenuBar());
    }

    private void setUpFrame() {
        setTitle("Wyporzyczanie sprzętu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        Utils.setWindowsLookAndFeel();
        setModal(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               // EquipmentController.getInstance().zapiszDaneDoPliku();
            }
        });
    }

    private void initComponents() {
        WypozyczeniaPresenter presenter = new WypozyczeniaPresenter(nazwisko);

        WypozyczeniaTopPanel wypozyczeniaTopPanel = new WypozyczeniaTopPanel();
        WypozyczeniaFormPanel clientFormPanel = new WypozyczeniaFormPanel();
        WypozyczeniaTablePanel clientCenterPanel = new WypozyczeniaTablePanel();

        add(wypozyczeniaTopPanel, BorderLayout.NORTH);
        add(clientFormPanel, BorderLayout.WEST);
        add(clientCenterPanel, BorderLayout.CENTER);

        presenter.setCzasWypozyczeniaCB(clientFormPanel.getCzasWypozyczeniaCB());
        presenter.setEquimpentCB(wypozyczeniaTopPanel.getEquimpentCB());
        presenter.setIloscSztukSpinner(clientFormPanel.getIloscSztukSpinner());
        presenter.setRezerwacjeTabela(clientCenterPanel.getRezerwacjeTabela());
        presenter.setWypozyczButton(clientFormPanel.getWypozyczButton());
        presenter.setUsunBtn(clientCenterPanel.getUsunBtn());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu aplikacjaMenu = new JMenu(Const.Menu.APPLICATION_MENU);
        menuBar.add(aplikacjaMenu);

        JMenuItem zamknijItem = new JMenuItem(Const.MenuItem.CLOSE_MENU_ITEM);
        zamknijItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aplikacjaMenu.add(zamknijItem);
        return menuBar;
    }
}
