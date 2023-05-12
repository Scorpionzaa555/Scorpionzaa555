package Test_final_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class View {

    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;

    public View() {
        createUI();
    }

    public void setTableModel(TaskTableModel tableModel) {
        table.setModel(tableModel);
    }

    public void addTaskAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void createUI() {
        // Create the JFrame
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the JTable and wrap it in a scroll pane
        table = new JTable();
        scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create the buttons and add them to a panel
        addButton = new JButton("Add Task");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.pack();
        frame.setVisible(true);
    }
}

//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class View extends JFrame {
//    private JTable taskTable;
//    private TaskTableModel taskTableModel;
//
//    public View(TaskTableModel taskTableModel) {
//        super("Task List");
//
//        this.taskTableModel = taskTableModel;
//        taskTable = new JTable(taskTableModel);
//        JScrollPane scrollPane = new JScrollPane(taskTable);
//
//        setPreferredSize(new Dimension(800, 600));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getContentPane().add(scrollPane, BorderLayout.CENTER);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public void updateView() {
//        taskTableModel.fireTableDataChanged();
//    }
//}
