package ui.admin.admin_choose.view;

import ui.admin.admin_choose.controller.AdminChoosePresenter;
import ui.login.view.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainFrame();
            }
        });
    }

    private void showMainFrame() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
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
