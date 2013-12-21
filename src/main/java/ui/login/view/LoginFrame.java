package ui.login.view;

import ui.login.controller.LoginPresenter;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame implements ClosableFrame  {

    public static final int WIDTH = 240;
    public static final int HEIGHT = 140;

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
        LoginPresenter loginPresenter = new LoginPresenter(this);

        FormPanel formPanel = new FormPanel();
        ButtonPanel buttonPanel = new ButtonPanel();

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        loginPresenter.setLastNameTF(formPanel.getLastNameTF());
        loginPresenter.setPasswordPF(formPanel.getPasswordPF());
        loginPresenter.setLoginBtn(buttonPanel.getLoginBtn());
    }

    @Override
    public void closeFrame() {
        dispose();
    }
}
