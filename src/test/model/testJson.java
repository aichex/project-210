package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testJson {
    protected void checkItem(String name, ToDoItem item) {
        assertEquals(name, item.getName());
    }
}
