import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame implements ActionListener {
    private JTextField taskField;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoList() {
        // Set up the GUI components
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add a label and text field for entering new tasks
        JLabel taskLabel = new JLabel("New Task:");
        taskField = new JTextField(20);
        JPanel taskPanel = new JPanel(new FlowLayout());
        taskPanel.add(taskLabel);
        taskPanel.add(taskField);
        add(taskPanel, BorderLayout.NORTH);

        // Add a list to display existing tasks
        listModel = new DefaultListModel<String>();
        taskList = new JList<String>(listModel);
        JScrollPane listScrollPane = new JScrollPane(taskList);
        add(listScrollPane, BorderLayout.CENTER);

        // Add a button for adding new tasks
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the window
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Task")) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        ToDoList app = new ToDoList();
    }
}