/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author MSI
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Model {
    private List<Data> dataList;
    private final String DATA_FILE_NAME = "data.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Model() {
        this.dataList = new ArrayList<>();
    }

    public void loadData() throws IOException {
        File file = new File(DATA_FILE_NAME);
        if (file.exists()) {
            String json = Files.readString(Paths.get(DATA_FILE_NAME));
            this.dataList = gson.fromJson(json, new TypeToken<List<Data>>() {}.getType());
        }
    }

    public void saveData() throws IOException {
        Path path = Paths.get(DATA_FILE_NAME);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        String json = gson.toJson(dataList);
        FileWriter writer = new FileWriter(DATA_FILE_NAME);
        writer.write(json);
        writer.close();
    }

    public void addData(Data data) {
        dataList.add(data);
    }

    public List<Data> getDataList() {
        return dataList;
    }
}
