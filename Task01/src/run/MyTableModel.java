/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

/**
 *
 * @author MSI
 */
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Name", "Age"};

    private List<MyData> dataList;

    public MyTableModel(List<MyData> dataList) {
        this.dataList = dataList;
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public int getRowCount() {
        return dataList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        MyData data = dataList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getName();
            case 1:
                return data.getAge();
            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        MyData data = dataList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                data.setName((String) value);
                break;
            case 1:
                data.setAge((Integer) value);
                break;
        }
    }
}
