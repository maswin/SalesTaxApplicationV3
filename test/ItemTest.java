import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTest {

    @Test
    public void totalCostOfBookOfPrice20AndQuantity2ShouldBe40() {
        Item item = new Item("Book", 20d, 2, Category.Book, false);
        assertEquals(40,item.calculateTotalPrice(), 0);
    }

    @Test
    public void itemOfCategoryBookShouldBeTaxExempted() {
        Item item = new Item("Book", 20d, 2, Category.Book, false);
        assertTrue(item.isTaxExempted());
    }

    @Test
    public void itemOfCategoryOtherShouldNotBeTaxExempted() {
        Item item = new Item("Perfume", 20d, 2, Category.Other, false);
        assertFalse(item.isTaxExempted());
    }

    @Test
    public void importedItemShouldReturnTrueOnCallingIsImported() {
        Item item = new Item("Chocolate", 20d, 2, Category.Food, true);
        assertTrue(item.isImported());
    }
}
