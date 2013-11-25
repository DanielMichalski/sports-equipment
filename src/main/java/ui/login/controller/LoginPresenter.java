package ui.login.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Daniel
 * Date: 24.11.13
 */
public class LoginPresenter {
    private JTextField lastNameTF;
    private JPasswordField passwordPF;

    class LoginBtnListenr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFormComplete()) {
                loginUser();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Uzupełnij wszystkie wymagane dane",
                        "Informacja",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void loginUser() {
        saveFormData();

        System.out.println("Loguj");
        System.out.println("pass: " + passwordPF.getText());
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
