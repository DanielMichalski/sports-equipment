package ui.client.view;

import model.CzasWypozyczenia;
import ui.client.model.CzasWypozyczeniaModel;

import javax.swing.*;
import java.awt.*;

public class WypozyczeniaFormPanel extends JPanel {
    private JComboBox<CzasWypozyczenia> czasWypozyczeniaCB;
    private JSpinner iloscSztukSpinner;
    private JButton wypozyczButton;

    public WypozyczeniaFormPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void initializeComponents() {
        Panel panel = new Panel();
        ButtonPanel buttonPanel = new ButtonPanel();

        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    class Panel extends JPanel {
        public Panel() {
            setLayout(new GridLayout(2, 2, 10, 10));

            JLabel czasWypLB = new JLabel("Czas wypożyczenia");
            CzasWypozyczeniaModel czasWypozyczeniaModel = new CzasWypozyczeniaModel();
            czasWypozyczeniaCB = new JComboBox<CzasWypozyczenia>(czasWypozyczeniaModel);

            JLabel iloscSztukLB = new JLabel("Ilość sztuk");
            iloscSztukSpinner = new JSpinner();

            add(czasWypLB);
            add(czasWypozyczeniaCB);
            add(iloscSztukLB);
            add(iloscSztukSpinner);
        }
    }

    class ButtonPanel extends JPanel {
        public ButtonPanel() {
            wypozyczButton = new JButton("Wypożycz");
            add(wypozyczButton);
        }
    }

    public JComboBox<CzasWypozyczenia> getCzasWypozyczeniaCB() {
        return czasWypozyczeniaCB;
    }

    public JSpinner getIloscSztukSpinner() {
        return iloscSztukSpinner;
    }

    public JButton getWypozyczButton() {
        return wypozyczButton;
    }
}
