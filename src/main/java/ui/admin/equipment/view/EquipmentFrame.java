package ui.admin.equipment.view;

import ui.admin.clients_registration.controller.RegistrationController;
import ui.admin.equipment.controller.EquipmentController;
import ui.admin.equipment.view.equipment_table.EquipmentTablePanel;
import ui.admin.equipment.view.euqipment_form.EquipmentLeftPanel;
import util.Const;
import util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EquipmentFrame extends JDialog {
    public static final int DEFAULT_WIDTH = 750;
    public static final int DEFAULT_HEIGHT = 320;

    public EquipmentFrame() {
        setUpFrame();
        initComponents();
        setJMenuBar(createMenuBar());
    }

    private void setUpFrame() {
        setTitle("Zarządzanie sprzętem");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        Utils.setWindowsLookAndFeel();
        setModal(true);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                EquipmentController.getInstance().zapiszDaneDoPliku();
            }
        });
    }

    private void initComponents() {
        EquipmentLeftPanel clientDataPanel = new EquipmentLeftPanel();
        EquipmentTablePanel clientTablePanel = new EquipmentTablePanel();

        add(clientDataPanel, BorderLayout.WEST);
        add(clientTablePanel, BorderLayout.CENTER);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu aplikacjaMenu = new JMenu(Const.Menu.APPLICATION_MENU);
        menuBar.add(aplikacjaMenu);

        JMenuItem zamknijItem = new JMenuItem(Const.MenuItem.CLOSE_MENU_ITEM);
        zamknijItem.setAccelerator(KeyStroke.getKeyStroke("control c"));
        zamknijItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aplikacjaMenu.add(zamknijItem);
        return menuBar;
    }

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X)
                System.exit(0);

            return false;
        }
    }
}
