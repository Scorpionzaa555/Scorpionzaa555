/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author MSI
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        try {
            model.loadData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to load data from file: " + e.getMessage());
        }

        view.showData(model.getDataList());

        view.setVisible(true);

        view.addButtonListener((ActionEvent e) -> {
            String id = view.getId();
            String name = view.getName();
            String age = view.getAge();
            
            if (id.isEmpty() || name.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }
            
            model.addData(new Data(id, name, age));
            
            try {
                model.saveData();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to save data to file: " + ex.getMessage());
            }
            
            view.showData(model.getDataList());
            
            view.clearFields();
        });
    }
}
