import ui.login.view.LoginFrame;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Utils.setWindowsLookAndFeel();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                loginFrame.setVisible(true);
            }
        });
    }
}
