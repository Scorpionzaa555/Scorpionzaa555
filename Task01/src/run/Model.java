package run;

//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class Model {
//    private List<Person> people;
//
//    public Model() {
//        people = new ArrayList<>();
//    }
//
//    public void loadJson(String path) {
//        try {
//            JSONParser parser = new JSONParser();
//            JSONArray array = (JSONArray) parser.parse(new FileReader(path));
//            for (Object obj : array) {
//                JSONObject json = (JSONObject) obj;
//                String name = (String) json.get("name");
//                int age = Integer.parseInt((String) json.get("age"));
//                String gender = (String) json.get("gender");
//                Person person = new Person(name, age, gender);
//                people.add(person);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Person> getPeople() {
//        return people;
//    }
//}

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Model {
    private ArrayList<Person> people;
    private DefaultTableModel tableModel;
    private final String FILE_PATH = "people.json";
    
    public Model() {
        people = new ArrayList<>();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Age");
    }
    
    public void addPerson(Person person) {
        people.add(person);
        tableModel.addRow(new Object[] {person.getId(), person.getFirstName(), person.getLastName(), person.getAge()});
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public boolean savePeopleToJson() {
        Gson gson = new Gson();
        String json = gson.toJson(people);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean loadPeopleFromJson() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            Gson gson = new Gson();
            Person[] personArray = gson.fromJson(json, Person[].class);
            
            for (Person person : personArray) {
                addPerson(person);
            }
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
