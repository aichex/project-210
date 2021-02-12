package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestToDoItem {
    private ToDoItem testItem;
    private ToDoItem testItem2;
    public String ITEM_NAME = "Date Night";
    public String INITIAL_STATUS = "Not Completed";


    @BeforeEach

    public void SetUp() {
        testItem = new ToDoItem(ITEM_NAME);
    }

    @Test
    public void testStatusCompleted() {
        testItem.statusCompleted();
        assertEquals(testItem.getStatus(), "completed");
    }

    @Test
    public void testStatusPending() {
        testItem.statusPending();
        assertEquals(testItem.getStatus(), "pending" );

    }
    @Test
    public void testChangeName() {
        testItem.changeName("Go to class");
        assertEquals(testItem.getName(), "Go to class");
    }

}

