import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ToDoListGUI {

    JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton addButton;
    private JScrollPane scrollPane;

    String toDoList = "";

    /**
     * Create the application.
     */
    public ToDoListGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("To-Do List App");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new BorderLayout(0, 0));

        inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputField.setColumns(10);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toDoList += inputField.getText() + "\n";
                outputArea.setText(toDoList);
                inputField.setText("");
            }
        });
        inputPanel.add(addButton, BorderLayout.EAST);

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

}