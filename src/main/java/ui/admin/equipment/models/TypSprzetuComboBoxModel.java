package ui.admin.equipment.models;

import model.TypSprzetu;

import javax.swing.*;

public class TypSprzetuComboBoxModel extends DefaultComboBoxModel<TypSprzetu> {
    public TypSprzetuComboBoxModel() {
        super(TypSprzetu.values());
    }
}
