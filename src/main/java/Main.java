import ui.login.view.LoginFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 * Date: 25.11.13
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                loginFrame.setVisible(true);
            }
        });
    }
}
