package ui.admin.equipment.models;

import model.Equimpent;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EquipmentTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"Marka oraz model", "Przeznaczenie", "Typ sprzętu", "Ilość sztuk"};
    private List<Equimpent> equimpents;

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public EquipmentTableModel(List<Equimpent> equipments) {
        super();
        if (equipments != null) {
            this.equimpents = equipments;

            System.out.println(equipments);
        } else {
            this.equimpents = new ArrayList<Equimpent>();
        }
    }

    @Override
    public int getRowCount() {
        return equimpents.size();
    }

    public void addEquipment(Equimpent equimpent) {
        equimpents.add(equimpent);
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equimpent equimpent = equimpents.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return equimpent.getMarka() + " " + equimpent.getModel();
            case 1:
                return equimpent.getPrzeznaczenie().toString();
            case 2:
                return equimpent.getTypSprzetu();
            case 3:
                return equimpent.getIloscSztuk();
            default:
                return "";
        }

    }

    public Equimpent getEquipmentByRow(int rowIndex) {
        return equimpents.get(rowIndex);
    }

    public void editclientByRow(Equimpent newEquipment, int rowIndex) {
        equimpents.set(rowIndex, newEquipment);
        fireTableDataChanged();
    }

    public void removeRow(int row) {
        equimpents.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public List<Equimpent> getEquimpents() {
        return equimpents;
    }
}
