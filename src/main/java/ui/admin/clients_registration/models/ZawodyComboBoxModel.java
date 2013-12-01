package ui.admin.clients_registration.models;

import model.Zawod;

import javax.swing.*;

public class ZawodyComboBoxModel extends DefaultComboBoxModel<Zawod> {
    public ZawodyComboBoxModel() {
        addElement(Zawod.student);
        addElement(Zawod.pracownik_fizyczny);
        addElement(Zawod.pracownik_umysłowy);
    }
}
