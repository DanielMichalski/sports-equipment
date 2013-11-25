package ui.login.view;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 * Date: 24.11.13
 */
public class FormPanel extends JPanel {
    private JTextField lastNameTF;
    private JPasswordField passwordPF;

    public FormPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setLayout(new GridLayout(2, 2, 0, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        setBackground(new Color(228, 250, 255));
    }

    private void initializeComponents() {
        JLabel lastNameLbl = new JLabel("Nazwisko:");
        lastNameTF = new JTextField();
        JLabel passwordLbl = new JLabel("Hasło:");
        passwordPF = new JPasswordField();

        add(lastNameLbl);
        add(lastNameTF);
        add(passwordLbl);
        add(passwordPF);
    }

    public JTextField getLastNameTF() {
        return lastNameTF;
    }

    public JPasswordField getPasswordPF() {
        return passwordPF;
    }
}
