package run;

//import java.awt.BorderLayout;
//import java.util.List;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//public class View extends JFrame {
//    private JTable table;
//
//    public View() {
//        table = new JTable();
//        JScrollPane scrollPane = new JScrollPane(table);
//        getContentPane().add(scrollPane, BorderLayout.CENTER);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public void updateTable(List<Person> people) {
//        Object[][] data = new Object[people.size()][3];
//        int row = 0;
//        for (Person person : people) {
//            data[row][0] = person.getName();
//            data[row][1] = person.getAge();
//            data[row][2] = person.getGender();
//            row++;
//        }
//        Object[] columnNames = {"Name", "Age", "Gender"};
//        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
//    }
//
//    Object getBtnLoadJson() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    Object getTxtJsonPath() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    Object getBtnSaveJson() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View extends JFrame implements ActionListener {
    private Model model;
    private JTable table;
    private JButton saveButton;
    private JButton loadButton;
    
    public View(Model model) {
        this.model = model;
        
        table = new JTable(model.getTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            boolean success = model.savePeopleToJson();
            if (success) {
                System.out.println("Data saved to JSON file.");
            } else {
                System.out.println("Error saving data to JSON file.");
            }
        } else if (e.getSource() == loadButton) {
            boolean success = model.loadPeopleFromJson();
            if (success) {
                System.out.println("Data loaded from JSON file.");
            } else {
                System.out.println("Error loading data from JSON file.");
            }
        }
    }
}
