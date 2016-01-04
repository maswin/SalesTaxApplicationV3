import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void totalCostOfBookOfPrice20AndQuantity2ShouldBe40() {
        Item item = new Item("Book", 20d, 2);
        assertEquals(40,item.calculateTotalPrice(), 0);
    }
}
