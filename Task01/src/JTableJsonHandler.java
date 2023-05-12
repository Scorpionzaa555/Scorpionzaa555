import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableJsonHandler {
    
    public static void writeTableDataToJson(JTable table, String filePath) throws IOException {
        // Convert table data to list of objects
        List<TableRowData> dataList = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            TableRowData row = new TableRowData(
                table.getValueAt(i, 0).toString(),
                table.getValueAt(i, 1).toString(),
                Integer.parseInt(table.getValueAt(i, 2).toString())
            );
            dataList.add(row);
        }
        
        // Serialize list to JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataList);
        
        // Write JSON to file
        FileWriter writer = new FileWriter(filePath);
        writer.write(json);
        writer.close();
    }
    
    public static void readTableDataFromJson(JTable table, String filePath) throws IOException {
        // Read JSON from file
        FileReader reader = new FileReader(filePath);
        Gson gson = new Gson();
        List<TableRowData> dataList = gson.fromJson(reader, new TypeToken<List<TableRowData>>(){}.getType());
        reader.close();
        
        // Convert list of objects to table data
        Object[][] rowData = new Object[dataList.size()][3];
        for (int i = 0; i < dataList.size(); i++) {
            TableRowData row = dataList.get(i);
            rowData[i][0] = row.getColumn1();
            rowData[i][1] = row.getColumn2();
            rowData[i][2] = row.getColumn3();
        }
        table.setModel(new DefaultTableModel(rowData, new String[] {"Column 1", "Column 2", "Column 3"}));
    }
    
    private static class TableRowData {
        private String column1;
        private String column2;
        private int column3;
        
        public TableRowData(String column1, String column2, int column3) {
            this.column1 = column1;
            this.column2 = column2;
            this.column3 = column3;
        }
        
        public String getColumn1() {
            return column1;
        }
        
        public String getColumn2() {
            return column2;
        }
        
        public int getColumn3() {
            return column3;
        }
    }
}
