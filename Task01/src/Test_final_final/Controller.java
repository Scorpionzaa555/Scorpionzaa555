package Test_final_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        // Add action listeners for buttons in view
        view.addAddTaskListener(new AddTaskListener());
        view.addSaveToFileListener(new SaveToFileListener());
        view.addLoadFromFileListener(new LoadFromFileListener());
    }

    // ActionListener for Add Task button
    private class AddTaskListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String taskName = view.getTaskName();
            String taskDescription = view.getTaskDescription();
            String taskPriority = view.getTaskPriority();

            // Add task to model
            model.addTask(taskName, taskDescription, taskPriority);

            // Update view's table with model's data
            view.updateTable(model.getTaskData());
        }
    }

    // ActionListener for Save to File button
    private class SaveToFileListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Open file chooser to select save location
            File selectedFile = view.showSaveFileChooser();

            if (selectedFile != null) {
                try {
                    // Write task data to file using ObjectStream
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile));
                    oos.writeObject(model.getTaskData());
                    oos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // ActionListener for Load from File button
    private class LoadFromFileListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Open file chooser to select file to load from
            File selectedFile = view.showOpenFileChooser();

            if (selectedFile != null) {
                try {
                    // Read task data from file using ObjectStream
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile));
                    ArrayList<Task> taskData = (ArrayList<Task>) ois.readObject();
                    ois.close();

                    // Update model's task data with loaded data and update view's table
                    model.setTaskData(taskData);
                    view.updateTable(model.getTaskData());
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
