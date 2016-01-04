import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SalesTaxCalculatorTest {

    @Test
    public void totalSalesTaxOfOneBookIs0() {
        List<Item> items = new ArrayList<>();
        Item item = Mockito.mock(Item.class);
        when(item.isTaxExempted()).thenReturn(true);
        items.add(item);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(0d, salesTaxCalculator.calculateTotalSalesTax(items), 0);
    }

    @Test
    public void totalSalesTaxOfOnePerfumeOfPrice11Point23AtSalesTaxRate10ShouldBeRoundedTo1Point10() throws Exception {
        List<Item> items = new ArrayList<>();
        Item item = Mockito.mock(Item.class);
        when(item.isTaxExempted()).thenReturn(false);
        when(item.calculateTotalPrice()).thenReturn(11.23);
        items.add(item);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(1.10, salesTaxCalculator.calculateTotalSalesTax(items), 0);
    }
}
