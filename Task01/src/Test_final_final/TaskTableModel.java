package Test_final_final;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TaskTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Task", "Priority", "Completed"};
    private ArrayList<Task> tasks;

    public TaskTableModel() {
        tasks = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0 || columnIndex == 1) {
            return String.class;
        } else if (columnIndex == 2) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        if (columnIndex == 0) {
            return task.getDescription();
        } else if (columnIndex == 1) {
            return task.getPriority();
        } else if (columnIndex == 2) {
            return task.isCompleted();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            Task task = tasks.get(rowIndex);
            task.setCompleted((Boolean) aValue);
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        fireTableRowsInserted(tasks.size() - 1, tasks.size() - 1);
    }

    public void removeTask(int rowIndex) {
        tasks.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Task getTask(int rowIndex) {
        return tasks.get(rowIndex);
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
        fireTableDataChanged();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

