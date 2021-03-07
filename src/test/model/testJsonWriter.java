package model;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testJsonWriter extends testJson {

    @Test
    void testWriterInvalidFile() {
        try {
            Categories c = new Categories("Restaurants");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testWriterEmptyCategories() {
        try {
            Categories c = new Categories("Restaurants");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCategories.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCategories.json");
            c = reader.read();
            assertEquals("Restaurants", c.getCategoryName());
            assertEquals(0, c.getListSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCategories() {
        try {
            Categories c = new Categories("Restaurants");
            c.addToDoItemInCategory(new ToDoItem("Mikus"));
            c.addToDoItemInCategory(new ToDoItem("Minami"));
            JsonWriter writer = new JsonWriter(("./data/testWriterGeneralCategories.json"));
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCategories.json");
            c = reader.read();
            assertEquals("Restaurants", c.getCategoryName());
            ArrayList<ToDoItem> items = c.getList();
            assertEquals(2, items.size());
            checkItem("Mikus",items.get(0));
            checkItem("Minami", items.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
