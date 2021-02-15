package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCategories {
    private Categories testCategory;
    private Categories testCategory2;
    private String CATEGORY_NAME = "Date Night";
    private ToDoItem TEST_TODO;


    @BeforeEach

public void Setup() {
    testCategory = new Categories("testCategory");
    testCategory2 = new Categories("testCategory2");
    }

    @Test

    public void testChangeCategoryName() {
        testCategory.changeName("Restaurant");
        assertEquals(testCategory.getCategoryName(), "Restaurant");
    }

    @Test
    public void testSearchForToDoItemOnlyOne() {
        ToDoItem s =  new ToDoItem("test");
        testCategory.addToDoItemInCategory(s);
        assertFalse(testCategory.searchForToDo("test") == null);
    }

    @Test
    public void testSearchForToDoItemEmpty() {
        assertTrue(testCategory.searchForToDo("anything") == null);
    }

    @Test
    public void testSearchForToDoItemMany() {
        ToDoItem n = new ToDoItem("run");
        testCategory.addToDoItemInCategory(n);
        ToDoItem s = new ToDoItem("test");
        testCategory.addToDoItemInCategory(s);
        assertFalse(testCategory.searchForToDo("test") == null);
    }

    @Test
    public void testDeleteToDo() {
        ToDoItem run = new ToDoItem("run");
        testCategory.addToDoItemInCategory(run);
        testCategory.deleteToDo(run.getName());
        assertEquals(testCategory.getListSize(), 0);
    }

    @Test
    public void testDeleteToDoEmpty() {
        testCategory.deleteToDo("");
        assertEquals(testCategory.getListSize(), 0);
    }

    @Test
    public void testDeleteToDoMany() {
        ToDoItem n = new ToDoItem("class");
        ToDoItem s = new ToDoItem("work");
        ToDoItem a = new ToDoItem("dinner");
        testCategory.addToDoItemInCategory(n);
        testCategory.addToDoItemInCategory(s);
        testCategory.addToDoItemInCategory(a);
        testCategory.deleteToDo("dinner");
        assertEquals(testCategory.getListSize(), 2);
    }

    @Test
    public void testDeleteNonExistentCase() {
        ToDoItem n = new ToDoItem("class");
        testCategory.addToDoItemInCategory(n);
        testCategory.deleteToDo("work");
        assertEquals(testCategory.getListSize(), 1);

    }

    @Test
    public void testAddToDoItem() {
        ToDoItem n = new ToDoItem("run");
        testCategory.addToDoItemInCategory(n);
        assertEquals(testCategory.getListSize(),1);
    }
}

