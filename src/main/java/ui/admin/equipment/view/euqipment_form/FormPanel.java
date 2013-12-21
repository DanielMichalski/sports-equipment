package ui.admin.equipment.view.euqipment_form;

import model.*;
import ui.admin.equipment.controller.EquipmentController;
import ui.admin.equipment.models.TypSprzetuComboBoxModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FormPanel extends JPanel {
    EquipmentController presenter = EquipmentController.getInstance();

    private JTextField markaTF;
    private JTextField modelTF;

    ButtonGroup radioBtnGroup;
    private JRadioButton snowboardRB;
    private JRadioButton nartyRB;

    private JComboBox rodzajSprzetu;
    private JSpinner iloscSztukSpinner;

    public FormPanel() {
        setUpPanel();
        initComponents();
    }

    private void setUpPanel() {
        GridLayout layout = new GridLayout(6, 2, 10, 15);
        setLayout(layout);
        setBorder(new TitledBorder("Dodawanie sprzętu"));
    }

    private void initComponents() {
        JLabel markaLbl = new JLabel("Marka");
        markaTF = new JTextField();

        JLabel modelLbl = new JLabel("Model");
        modelTF = new JTextField();

        JPanel radioBtnPanel = new JPanel();
        JLabel przeznaczenieLbl = new JLabel("Przeznaczenie");
        radioBtnGroup = new ButtonGroup();
        snowboardRB = new JRadioButton("Snowboard");
        nartyRB = new JRadioButton("Narty");
        radioBtnGroup.add(snowboardRB);
        radioBtnGroup.add(nartyRB);
        radioBtnPanel.add(snowboardRB);
        radioBtnPanel.add(nartyRB);
        snowboardRB.setSelected(true);

        JLabel zawodLabel = new JLabel("Typ sprzętu");
        rodzajSprzetu = new JComboBox<TypSprzetu>(new TypSprzetuComboBoxModel());

        JLabel iloscSztukLb = new JLabel("Ilość sztuk");
        iloscSztukSpinner = new JSpinner();

        add(markaLbl);
        add(markaTF);

        add(modelLbl);
        add(modelTF);

        add(przeznaczenieLbl);
        add(radioBtnPanel);

        add(zawodLabel);
        add(rodzajSprzetu);

        add(iloscSztukLb);
        add(iloscSztukSpinner);

        presenter.setFormPanel(this);
    }

    public Equimpent getequipmentFromFields() {
        return new Equimpent(
                markaTF.getText(),
                modelTF.getText(),
                getPrzeznaczenieFromFields(),
                (TypSprzetu) rodzajSprzetu.getSelectedItem(),
                Integer.parseInt(iloscSztukSpinner.getValue().toString()));
    }

    private Przeznaczenie getPrzeznaczenieFromFields() {
        if (snowboardRB.isSelected())
            return Przeznaczenie.Snowobard;
        else
            return Przeznaczenie.Narty;
    }

    public void clearForm() {
        markaTF.setText("");
        modelTF.setText("");
        snowboardRB.setSelected(true);
        rodzajSprzetu.setSelectedIndex(0);
        iloscSztukSpinner.setValue(0);
    }

    public void fillForm(Equimpent equimpent) {
        markaTF.setText(equimpent.getMarka());
        modelTF.setText(equimpent.getModel());
        if (equimpent.getPrzeznaczenie() == Przeznaczenie.Narty) nartyRB.setSelected(true);
        else snowboardRB.setSelected(true);
        rodzajSprzetu.getModel().setSelectedItem(equimpent.getTypSprzetu());
        iloscSztukSpinner.setValue(equimpent.getIloscSztuk());
    }

    public JTextField getMarkaTF() {
        return markaTF;
    }

    public JTextField getModelTF() {
        return modelTF;
    }

    public JSpinner getIloscSztukSpinner() {
        return iloscSztukSpinner;
    }
}
