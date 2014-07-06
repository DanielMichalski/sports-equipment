package ui.client.view;

import ui.client.controller.WypozyczeniaPresenter;
import ui.login.view.LoginFrame;
import util.Const;
import util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WypozyczeniaFrame extends JDialog {
    public static final int DEFAULT_WIDTH = 850;
    public static final int DEFAULT_HEIGHT = 320;

    private String nazwisko;

    public WypozyczeniaFrame(String nazwisko) {
        this.nazwisko = nazwisko;

        setUpFrame();
        initComponents();
        setJMenuBar(createMenuBar());
    }

    private void setUpFrame() {
        setTitle("Wyporzyczanie sprzętu - klient " + nazwisko);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        Utils.setWindowsLookAndFeel();
        setModal(true);
    }

    private void initComponents() {
        WypozyczeniaPresenter presenter = new WypozyczeniaPresenter(nazwisko);

        WypozyczeniaTopPanel wypozyczeniaTopPanel = new WypozyczeniaTopPanel();
        WypozyczeniaFormPanel clientFormPanel = new WypozyczeniaFormPanel();
        WypozyczeniaTablePanel clientCenterPanel = new WypozyczeniaTablePanel(presenter);

        add(wypozyczeniaTopPanel, BorderLayout.NORTH);
        add(clientFormPanel, BorderLayout.WEST);
        add(clientCenterPanel, BorderLayout.CENTER);

        presenter.setCzasWypozyczeniaCB(clientFormPanel.getCzasWypozyczeniaCB());
        presenter.setEquimpentCB(wypozyczeniaTopPanel.getEquimpentCB());
        presenter.setIloscSztukSpinner(clientFormPanel.getIloscSztukSpinner());
        presenter.setRezerwacjeTabela(clientCenterPanel.getRezerwacjeTabela());
        presenter.setWypozyczButton(clientFormPanel.getWypozyczButton());
        presenter.setUsunBtn(clientCenterPanel.getUsunBtn());

        addWindowListener(presenter.getWindowListener());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu aplikacjaMenu = new JMenu(Const.Menu.APPLICATION_MENU);
        menuBar.add(aplikacjaMenu);

        JMenuItem wylogujMenuItem = new JMenuItem("Wyloguj");
        wylogujMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                loginFrame.setVisible(true);
            }
        });

        JMenuItem zamknijItem = new JMenuItem(Const.MenuItem.CLOSE_MENU_ITEM);
        zamknijItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aplikacjaMenu.add(wylogujMenuItem);
        aplikacjaMenu.add(zamknijItem);
        return menuBar;
    }
}
