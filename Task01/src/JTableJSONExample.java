import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JTableJSONExample {

    public static void main(String[] args) {
        // Create a JTable
        String[] columnNames = {"ID", "Name", "Age", "Gender"};
        Object[][] data = {
            {1, "John", 25, "Male"},
            {2, "Jane", 30, "Female"},
            {3, "Bob", 35, "Male"}
        };
        JTable table = new JTable(data, columnNames);

        // Serialize JTable data to JSON file
        List<Object[]> rows = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            Object[] row = new Object[table.getColumnCount()];
            for (int j = 0; j < table.getColumnCount(); j++) {
                row[j] = table.getValueAt(i, j);
            }
            rows.add(row);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(rows);
        try (FileWriter writer = new FileWriter("table.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize JTable data from JSON file and display it in a new JTable
        try (FileReader reader = new FileReader("table.json")) {
            List<Object[]> rows2 = gson.fromJson(reader, new TypeToken<List<Object[]>>() {}.getType());
            Object[][] data2 = new Object[rows2.size()][];
            for (int i = 0; i < rows2.size(); i++) {
                data2[i] = rows2.get(i);
            }
            JTable table2 = new JTable(data2, columnNames);
            JFrame frame = new JFrame();
            frame.add(new JScrollPane(table2));
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
