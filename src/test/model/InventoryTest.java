package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {
    private Inventory testInventory;
    private String INVENTORY_NAME = "Hasen's BucketList";
    private Categories testCategory;


    @BeforeEach

    public void setup() {
        testInventory = new Inventory(INVENTORY_NAME);
        testCategory  = new Categories("Restaurants");
    }

    @Test
    public void addCategoryToEmptyInventory() {
        assertTrue(testInventory.getCategories().isEmpty());
        testInventory.addCategory(INVENTORY_NAME);
        assertEquals(testInventory.getCategories().size(), 1);
    }

    @Test
    public void addCategoryToInventoryMany() {
        testInventory.addCategory(INVENTORY_NAME);
        testInventory.addCategory("Restaurants");
        assertEquals(testInventory.getCategories().size(), 2);
    }

    @Test

    public void searchForCategoryEmpty() {
        assertEquals(testInventory.searchForCategory(INVENTORY_NAME), null);
    }

    @Test

    public void searchForCategoryNotExist() {
        testInventory.addCategory(testCategory.getCategoryName());
        assertEquals(testInventory.searchForCategory("test"), null);
    }

    @Test

    public void testAddCategory() {
        testInventory.addCategory(new Categories("test"));
        assertEquals(testInventory.getCategoryNames(testInventory.getCategories()), "test");
    }

}