import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoListGUI1 extends JFrame {
    private JList<String> todoList;
    private DefaultListModel<String> listModel;
    private JButton addButton, removeButton;
    private JTextField todoItemField;
    
    public TodoListGUI1() {
        super("Todo List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Create a list model and a JList to display it
        listModel = new DefaultListModel<String>();
        todoList = new JList<String>(listModel);
        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create a panel for the text field and buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        add(controlPanel, BorderLayout.SOUTH);
        
        // Create a text field for entering new todo items
        todoItemField = new JTextField();
        todoItemField.setMaximumSize(new Dimension(Integer.MAX_VALUE, todoItemField.getPreferredSize().height));
        controlPanel.add(todoItemField);
        
        // Create an "Add" button to add new todo items to the list
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newItem = todoItemField.getText();
                if (!newItem.isEmpty()) {
                    listModel.addElement(newItem);
                    todoItemField.setText("");
                }
            }
        });
        controlPanel.add(addButton);
        
        // Create a "Remove" button to remove selected todo items from the list
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndices = todoList.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    listModel.removeElementAt(selectedIndices[i]);
                }
            }
        });
        controlPanel.add(removeButton);
        
        // Pack and display the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TodoListGUI1();
    }
}
