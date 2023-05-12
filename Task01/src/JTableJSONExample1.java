//import java.awt.BorderLayout;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonIOException;
//import com.google.gson.reflect.TypeToken;
//
//public class JTableJSONExample1 extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JTable table;
//    private DefaultTableModel tableModel;
//
//    public JTableJSONExample1() {
//        super("JTable JSON Example");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        tableModel = new DefaultTableModel();
//        tableModel.addColumn("Name");
//        tableModel.addColumn("Age");
//        tableModel.addColumn("Gender");
//        table = new JTable(tableModel);
//
//        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
//
//        setSize(400, 300);
//        setLocationRelativeTo(null);
//    }
//
//    public void readFromJson(File file) {
//        try {
//            Gson gson = new GsonBuilder().create();
//            List<Person> persons = gson.fromJson(fileReader(file), new TypeToken<List<Person>>(){}.getType());
//            for (Person person : persons) {
//                Object[] row = { person.getName(), person.getAge(), person.getGender() };
//                tableModel.addRow(row);
//            }
//        } catch (JsonIOException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void writeToJSON(File file) {
//        List<Person> persons = new ArrayList<Person>();
//        for (int i = 0; i < tableModel.getRowCount(); i++) {
//            String name = tableModel.getValueAt(i, 0).toString();
//            int age = Integer.parseInt(tableModel.getValueAt(i, 1).toString());
//            String gender = tableModel.getValueAt(i, 2).toString();
//            persons.add(new Person(name, age, gender));
//        }
//        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            fileWriter(file, gson.toJson(persons));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void fileWriter(File file, String data) throws IOException {
//        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
//            writer.write(data);
//        }
//    }
//
//    private String fileReader(File file) throws IOException {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (java.io.FileReader reader = new java.io.FileReader(file)) {
//            int data;
//            while ((data = reader.read()) != -1) {
//                stringBuilder.append((char) data);
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JTableJSONExample frame = new JTableJSONExample();
//            File file = new File("data.json");
//            if (file.exists()) {
//                frame.readFromJson(file);
//            }
//            frame.setVisible(true);
//        });
//    }
//
//    private static class Person {
//        private String name;
//        private int age;
//        private String gender;
//
//        public Person(String name, int age, String gender) {
//            this.name = name;
//            this.age = age;
//            this.gender = gender;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public String getGender() {
//            return gender;
//        }
//    }
//}
//
