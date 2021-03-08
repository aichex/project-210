package persistence;


import model.Categories;
import model.ToDoItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;


public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads category from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Categories readCategories() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCategories(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //EFFECTS: Parses Categories from JSON object and returns it
    private Categories parseCategories(JSONObject jso) {
        String name = jso.getString("name");
        Categories c = new Categories(name);
        addItems(c, jso);
        return c;
    }

    //MODIFIES: Categories
    //EFFECTS: parses items from JSON object and adds them to Category
    private void addItems(Categories c, JSONObject jso) {
        JSONArray jsonArray = jso.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(c, nextItem);
        }
    }

    //MODIFIES: Categories
    //EFFECTS: parses item from JSON object and adds it to Category
    private void addItem(Categories c, JSONObject jso) {
        String name = jso.getString("name");
        String date = jso.getString("date");
        double cost = jso.getDouble("cost");
        ToDoItem item = new ToDoItem(name);
        item.setCost(cost);
        item.setDate(date);
        c.addToDoItemInCategory(item);
    }


}

