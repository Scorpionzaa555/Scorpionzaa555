package Test_final_final;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> toDoList = new ArrayList<>();

    public List<String> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<String> toDoList) {
        this.toDoList = toDoList;
    }

    public void addItem(String item) {
        toDoList.add(item);
    }

    public void removeItem(int index) {
        toDoList.remove(index);
    }
}
