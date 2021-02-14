package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestToDoItem {
    private ToDoItem testItem;
    private ToDoItem testItem2;
    public String ITEM_NAME = "Date Night";
    public String ITEM_NAME2 = "Go to New York";
    public String INITIAL_STATUS = "Not Completed";
    public String DUE_DATE = "01/01/21";

    @BeforeEach

    public void SetUp() {
        testItem = new ToDoItem(ITEM_NAME);
        testItem2 = new ToDoItem(ITEM_NAME2);
    }

    @Test
    public void testStatusCompleted() {
        testItem.statusCompleted();
        assertEquals(testItem.getStatus(), "completed");
    }

    @Test
    public void testStatusPending() {
        testItem.statusPending();
        assertEquals(testItem.getStatus(), "pending");

    }

    @Test
    public void testChangeName() {
        testItem.changeName("Go to class");
        assertEquals(testItem.getName(), "Go to class");
    }

    @Test
    public void testChangeDate() {
        testItem.setDate(DUE_DATE);
        assertEquals(testItem.getDate(), "01/01/21");
    }

}

