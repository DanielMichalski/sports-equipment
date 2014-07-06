package ui.login.controller;

import dao.ClientsDao;
import ui.admin.admin_choose.view.AdminChooseFrame;
import ui.client.view.WypozyczeniaFrame;
import ui.login.view.ClosableFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPresenter {
    private JTextField lastNameTF;
    private JPasswordField passwordPF;

    private ClosableFrame closableFrame;

    public LoginPresenter(ClosableFrame closableFrame) {
        this.closableFrame = closableFrame;
    }

    class LoginBtnListenr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFormComplete()) {
                checkUser();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Uzupełnij wszystkie wymagane dane",
                        "Informacja",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void checkUser() {
        String lastName = lastNameTF.getText();
        String password = String.valueOf(passwordPF.getPassword());

        if (lastName.equals("admin") && password.equals("admin")) {
            closableFrame.closeFrame();
            loginUser();
        } else if (ClientsDao.isClientExist(lastName, password)) {
            closableFrame.closeFrame();
            showReservationFrame();
        } else {
            pokazInfoNieprawidloweDane();
        }
    }

    private void showReservationFrame() {
        WypozyczeniaFrame wypozyczeniaFrame = new WypozyczeniaFrame(lastNameTF.getText());
        wypozyczeniaFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        wypozyczeniaFrame.setVisible(true);
    }

    private void pokazInfoNieprawidloweDane() {
        JOptionPane.showMessageDialog(
                null,
                "Podano nieprawidłowe dane logowania",
                "Informacja",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void loginUser() {
        saveFormData();
        clearForm();

        AdminChooseFrame frame = new AdminChooseFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void clearForm() {
        lastNameTF.setText("");
        passwordPF.setText("");
    }

    private void saveFormData() {
        System.setProperty("lastName", lastNameTF.getText());
        System.setProperty("password", passwordPF.getText());
    }

    private boolean isFormComplete() {

        return !(lastNameTF.getText().trim().equals("") ||
                passwordPF.getText().trim().equals(""));

    }

    public void setLastNameTF(JTextField lastNameTF) {
        this.lastNameTF = lastNameTF;
    }

    public void setPasswordPF(JPasswordField passwordPF) {
        this.passwordPF = passwordPF;
    }

    public void setLoginBtn(JButton loginBtn) {
        loginBtn.addActionListener(new LoginBtnListenr());
    }
}
