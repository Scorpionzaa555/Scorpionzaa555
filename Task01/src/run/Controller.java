package run;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//public class Controller {
//    private Model model;
//    private View view;
//
//    public Controller(Model model, View view) {
//        this.model = model;
//        this.view = view;
//
//        view.setVisible(true);
//
//        view.updateTable(model.getPeople());
//
//        view.getBtnLoadJson().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                model.loadJson(view.getTxtJsonPath().getText());
//                view.updateTable(model.getPeople());
//            }
//        });
//
//        view.getBtnSaveJson().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                List<Person> people = model.getPeople();
//                JSONArray array = new JSONArray();
//                for (Person person : people) {
//                    JSONObject json = new JSONObject();
//                    json.put("name", person.getName());
//                    json.put("age", person.getAge());
//                    json.put("gender", person.getGender());
//                    array.add(json);
//                }
//                String jsonText = array.toJSONString();
//                try {
//                    java.io.FileWriter file = new java.io.FileWriter(view.getTxtJsonPath().getText());
//                    file.write(jsonText);
//                    file.flush();
//                    file.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }
//}

public class Controller {
    private Model model;
    private View view;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    public void initialize() {
        view.setVisible(true);
    }
}
/*

And here's how you can use these classes in your NetBeans project:

*/

