package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCategories {
    private Categories testCategory;
    private Categories testCategory2;
    public String CATEGORY_NAME = "Date Night";

    @BeforeEach

public void Setup() {
    testCategory = new Categories("testCategory");
    testCategory2 = new Categories("testCategory2");
    }

    @Test

    public void testChangeCategoryName() {
        testCategory.changeCategoryName("Restaurant");
        assertEquals(testCategory.getCategoryName(), "Restaurant");
    }

}

