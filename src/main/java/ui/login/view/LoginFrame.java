package ui.login.view;

import ui.login.controller.LoginPresenter;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 * Date: 24.11.13
 */
public class LoginFrame extends JFrame  {

    public static final int WIDTH = 240;
    public static final int HEIGHT = 160;

    public LoginFrame() {
        setUpFrame();
        initializeComponents();
    }

    private void setUpFrame() {
        setTitle("Logowanie");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(228, 250, 255));
    }

    private void initializeComponents() {
        LoginPresenter loginPresenter = new LoginPresenter();

        FormPanel formPanel = new FormPanel();
        ButtonPanel buttonPanel = new ButtonPanel();

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        loginPresenter.setLastNameTF(formPanel.getLastNameTF());
        loginPresenter.setPasswordPF(formPanel.getPasswordPF());
        loginPresenter.setLoginBtn(buttonPanel.getLoginBtn());
    }
}
