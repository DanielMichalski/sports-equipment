package ui.admin.admin_choose.controller;

import ui.admin.clients_registration.view.RegistrationFrame;
import ui.admin.equipment.view.EquipmentFrame;
import ui.login.view.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminChoosePresenter {

    private final JFrame adminChoose;

    public AdminChoosePresenter(JFrame frame) {
        this.adminChoose = frame;
    }

    class ClientBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegistrationFrame frame = new RegistrationFrame();
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    class EquipmentBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EquipmentFrame frame = new EquipmentFrame();
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    class WylogujListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminChoosePresenter.this.adminChoose.dispose();

            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            loginFrame.setVisible(true);
        }
    }

    class ZamknijListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public void setClientsBtn(JButton clientsBtn) {
        clientsBtn.addActionListener(new ClientBtnListener());
    }

    public void setEquipmentBtn(JButton equipmentBtn) {
        equipmentBtn.addActionListener(new EquipmentBtnListener());
    }

    public void setWylogujMenuItem(JMenuItem wylogujMenuItem) {
        wylogujMenuItem.addActionListener(new WylogujListener());
    }

    public void setZamknijMenuItem(JMenuItem zamknijMenuItem) {
        zamknijMenuItem.addActionListener(new ZamknijListener());
    }
}
