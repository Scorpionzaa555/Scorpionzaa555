package test_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryController implements ActionListener {

    private int currentIndex = 0;
    private HistoryModel historyModel;

    private EditItemView editItemView;
    private InsertItemView insertItemView;
    private HistoryView historyView;

    public HistoryController() {
        // TODO Auto-generated constructor stub
        historyView = new HistoryView();
        insertItemView = new InsertItemView();
        editItemView = new EditItemView();
        historyModel = new HistoryModel();

        //historyView.getButtonLogout().addActionListener(this);
        historyView.getButtonEditItem().addActionListener(this);
        historyView.getButtonAddItem().addActionListener(this);
        editItemView.getClose().addActionListener(this);
        editItemView.getDelete().addActionListener(this);
        editItemView.getNext().addActionListener(this);
        editItemView.getPrevious().addActionListener(this);
        editItemView.getUpdate().addActionListener(this);
        insertItemView.getInsert().addActionListener(this);

        historyView.getFrame().addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                historyModel.loadData();
                refrashTable();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                historyModel.saveData();
            }

        });
    }

    public static void main(String[] args) {
        new HistoryController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(loginView.getLogin())) {
//            String username = loginView.getUsername().getText();
//            String password = loginView.getPassword().getText();
//
//            if (username.equals("jisso") && password.equals("flower_me")) {
//                JOptionPane.showMessageDialog(null, "Login Success");
//                loginView.getFrame().dispose();
//
//                // Spawn dashboard frame
//                dashboardView.getFrame().setVisible(true);
//            }
//        }

        historyView.getFrame().setVisible(true);

        if ((e.getSource().equals(editItemView.getDelete())) && (historyModel.getItems().size() != 0)) {
            historyModel.getItems().remove(currentIndex);
            JOptionPane.showMessageDialog(null, "Done it.");
            if (currentIndex > 0) {
                currentIndex--;
                setCurrentEditItem(currentIndex);
            }
        }

        if (e.getSource().equals(editItemView.getUpdate())) {
            Item item = historyModel.getItems().get(currentIndex);
            item.setId(Integer.parseInt(editItemView.getId().getText()));
            item.setName(editItemView.getName().getText());
            item.setDescription((editItemView.getDescription().getText()));
            JOptionPane.showMessageDialog(null, "Done it.");
        }

        if (e.getSource().equals(editItemView.getPrevious()) && currentIndex > 0) {
            currentIndex--;
            setCurrentEditItem(currentIndex);
        }

        if (e.getSource().equals(editItemView.getNext()) && currentIndex + 1 < historyModel.getItems().size()) {
            currentIndex++;
            setCurrentEditItem(currentIndex);
        }

        if (e.getSource().equals(editItemView.getClose())) {
            editItemView.getFrame().dispose();
            historyView.getFrame().setVisible(true);
        }

        if (e.getSource().equals(historyView.getButtonEditItem())) {
            historyView.getFrame().dispose();
            editItemView.getFrame().setVisible(true);

            setCurrentEditItem(currentIndex);
        }

        if (e.getSource().equals(insertItemView.getInsert())) {
            Item item = new Item();
            item.setId(Integer.parseInt(insertItemView.getId().getText()));
            item.setName(insertItemView.getName().getText());
            item.setDescription((insertItemView.getDescription().getText()));
            item.setExpire(new Date());

            historyModel.addItem(item);
            JOptionPane.showMessageDialog(null, "Done it.");
            insertItemView.getFrame().dispose();

            historyView.getFrame().setVisible(true);
            refrashTable();
        }

        if (e.getSource().equals(historyView.getButtonAddItem())) {
            historyView.getFrame().dispose();
            insertItemView.getFrame().setVisible(true);
        }

//        if (e.getSource().equals(historyView.getButtonLogout())) {
//            historyModel.saveData();
//            historyView.getFrame().dispose();
//            JOptionPane.showMessageDialog(null, "Logout Success");
//
//            // Spawn login frame
//            loginView.getFrame().setVisible(true);
//        }
    }

    private void setCurrentEditItem(int currentIndex) {
        if (!editItemView.getFrame().isVisible()) {
            return;
        }
        Item item = historyModel.getItems().get(currentIndex);
        editItemView.getId().setText(String.valueOf(item.getId()));
        editItemView.getName().setText(item.getName());
        editItemView.getDescription().setText(String.valueOf(item.getDescription()));
    }

    @SuppressWarnings("deprecation")
    private void refrashTable() {
        JTable table = historyView.getTable();
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        for (Item item : historyModel.getItems()) {
            String format = item.getExpire().getDay() + "/" + (item.getExpire().getMonth() + 1) + "/" + (item.getExpire().getYear() + 1900);
            Object[] data = {item.getId(), item.getName(), item.getDescription(), format};
            ((DefaultTableModel) table.getModel()).addRow(data);
        }
    }
}
