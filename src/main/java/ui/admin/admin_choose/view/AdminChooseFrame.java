package ui.admin.admin_choose.view;

import ui.admin.admin_choose.controller.AdminChoosePresenter;

import javax.swing.*;
import java.awt.*;

public class AdminChooseFrame extends JFrame {
    private JMenuItem wylogujMenuItem;
    private JMenuItem zamknijMenuItem;

    public AdminChooseFrame() {
        setUpFrame();
        initializeComponents();
    }

    private void initializeComponents() {
        setJMenuBar(createJMenuBar());

        AdminChoosePresenter presenter = new AdminChoosePresenter(this);

        AdminChoosePanel panel = new AdminChoosePanel();
        add(panel);

        presenter.setClientsBtn(panel.getClientsBtn());
        presenter.setEquipmentBtn(panel.getEquipmentBtn());
        presenter.setWylogujMenuItem(wylogujMenuItem);
        presenter.setZamknijMenuItem(zamknijMenuItem);
    }

    private void setUpFrame() {
        setSize(new Dimension(300, 200));
        setTitle("Wybierz opcję");
        setLocationRelativeTo(null);
    }

    private JMenuBar createJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu plikMenuItem = new JMenu("Plik");
        wylogujMenuItem = new JMenuItem("Wyloguj");
        zamknijMenuItem = new JMenuItem("Zamknij");

        menuBar.add(plikMenuItem);

        plikMenuItem.add(wylogujMenuItem);
        plikMenuItem.add(zamknijMenuItem);

        return menuBar;
    }
}
