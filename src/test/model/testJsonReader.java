package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testJsonReader extends testJson {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Categories c = reader.read();
            fail("IOException expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testReaderEmptyCategory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCategory.json");
        try {
            Categories c = reader.read();
            assertEquals("Restaurants", c.getCategoryName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
