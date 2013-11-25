package ui.login.view;
import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 * Date: 24.11.13
 */
public class ButtonPanel extends JPanel {
    private JButton loginBtn;

    public ButtonPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        setBackground(new Color(228, 250, 255));
    }

    private void initializeComponents() {
        loginBtn = new JButton("Zaloguj");

        add(loginBtn);
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }
}
