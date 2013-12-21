package ui.admin.clients_registration.view.client_data;

import model.Client;
import model.Plec;
import model.Zawod;
import ui.admin.clients_registration.controller.RegistrationController;
import ui.admin.clients_registration.models.ZawodyComboBoxModel;
import util.Const;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FormPanel extends JPanel {
    RegistrationController presenter = RegistrationController.getInstance();

    private JTextField imieTF;
    private JTextField nazwiskoTF;
    private JPasswordField hasloPF;

    ButtonGroup radioBtnGroup;
    private JRadioButton kobietaRB;
    private JRadioButton mezczyznaRB;

    private JComboBox zawodCB;

    public FormPanel() {
        setUpPanel();
        initComponents();
    }

    private void setUpPanel() {
        GridLayout layout = new GridLayout(7, 2);
        setLayout(layout);
        layout.setVgap(7);
        setBorder(new TitledBorder("Rejestracja klientów"));
    }

    private void initComponents() {
        JLabel imieLbl = new JLabel(Const.Labels.NAME);
        imieTF = new JTextField();

        JLabel nazwiskoLbl = new JLabel(Const.Labels.SURNAME);
        nazwiskoTF = new JTextField();

        JLabel hasloLb = new JLabel(Const.Labels.PASSWORD);
        hasloPF = new JPasswordField();

        JPanel radioBtnPanel = new JPanel();
        JLabel płecLbl = new JLabel(Const.Labels.GENDER);
        radioBtnGroup = new ButtonGroup();
        kobietaRB = new JRadioButton("Kobieta");
        mezczyznaRB = new JRadioButton("Mężczyzna");
        radioBtnGroup.add(kobietaRB);
        radioBtnGroup.add(mezczyznaRB);
        radioBtnPanel.add(kobietaRB);
        radioBtnPanel.add(mezczyznaRB);
        kobietaRB.setSelected(true);

        JLabel zawodLabel = new JLabel(Const.Labels.PROFESSION);
        zawodCB = new JComboBox<Zawod>(new ZawodyComboBoxModel());

        add(imieLbl);
        add(imieTF);

        add(nazwiskoLbl);
        add(nazwiskoTF);

        add(hasloLb);
        add(hasloPF);

        add(płecLbl);
        add(radioBtnPanel);

        add(zawodLabel);
        add(zawodCB);

        presenter.setFormPanel(this);
    }

    public Client getclientFromFields() {
        return new Client(
                imieTF.getText(),
                nazwiskoTF.getText(),
                String.valueOf(hasloPF.getPassword()),
                getGenderFromFields(),
                (Zawod) zawodCB.getSelectedItem());
    }

    private Plec getGenderFromFields() {
        if (kobietaRB.isSelected())
            return Plec.Kobieta;
        else
            return Plec.Mężczyzna;
    }

    public void clearForm() {
        imieTF.setText("");
        nazwiskoTF.setText("");
        hasloPF.setText("");
        kobietaRB.setSelected(true);
        zawodCB.getModel().setSelectedItem(Zawod.student);
    }

    public void fillForm(Client client) {
        imieTF.setText(client.getImie());
        nazwiskoTF.setText(client.getNazwisko());
        hasloPF.setText(client.getHaslo());
        if (client.getPlec() == Plec.Mężczyzna) mezczyznaRB.setSelected(true);
        else kobietaRB.setSelected(true);
        zawodCB.getModel().setSelectedItem(client.getZawod());
    }

    public JTextField getImieTF() {
        return imieTF;
    }

    public JTextField getNazwiskoTF() {
        return nazwiskoTF;
    }

    public JPasswordField getHasloPF() {
        return hasloPF;
    }
}
