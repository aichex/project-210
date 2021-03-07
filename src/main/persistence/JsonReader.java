package persistence;

import com.sun.tools.doclets.standard.Standard;
import model.Categories;
import model.Inventory;
import model.Completed;
import model.ToDoItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads Categories from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads category from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Categories read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCategories(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private Categories parseCategories(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Categories c = new Categories(name);
        addItems(c, jsonObject);
        return c;
    }

    private void addItems(Categories c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(c,nextItem);
        }
    }

    private void addItem(Categories c, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String date = jsonObject.getString("date");
        double cost = jsonObject.getDouble("cost");
        ToDoItem item = new ToDoItem(name);
        item.setCost(cost);
        item.setDate(date);
        c.addToDoItemInCategory(item);
    }
}
