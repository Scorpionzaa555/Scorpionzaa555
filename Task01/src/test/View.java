/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author MSI
 */
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Data Table");
        setSize(500, 500);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public void showData(List<Data> dataList) {
        tableModel.setRowCount(0); // clear the table
        for (Data data : dataList) {
            Object[] rowData = { data.getId(), data.getName(), data.getAge() };
            tableModel.addRow(rowData);
        }
        setVisible(true);
    }
    
    public void addButtonListener(ActionListener listener) {
        // Add an action listener to the button
        // ...
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
