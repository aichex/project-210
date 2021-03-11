package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Categories c = reader.readCategories();
            fail("IOException expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testReaderEmptyCategory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCategory.json");
        try {
            Categories c = reader.readCategories();
            assertEquals("Restaurants", c.getCategoryName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCategory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCategory.json");
        try {
            Categories c = reader.readCategories();
            assertEquals("Restaurants", c.getCategoryName());
            ArrayList<ToDoItem> items = c.getList();
            assertEquals(2, items.size());
            checkItem("Mikus", items.get(0));
            checkItem("Minami", items.get(1));
        } catch (IOException e) {
            System.out.println("Couldn't read from file");
        }
    }
}
