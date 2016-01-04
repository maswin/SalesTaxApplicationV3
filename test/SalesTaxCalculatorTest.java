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
    public void totalSalesTaxOfOnePerfumeOfPrice11Point23AtSalesTaxRate10ShouldBeRoundedTo1Point10() {
        List<Item> items = new ArrayList<>();
        Item item = Mockito.mock(Item.class);
        when(item.isTaxExempted()).thenReturn(false);
        when(item.calculateTotalPrice()).thenReturn(11.23);
        items.add(item);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(1.10, salesTaxCalculator.calculateTotalSalesTax(items), 0);
    }

    @Test
    public void totalSalesTaxOfOneImportedPerfumeOfPrice10AtSalesTaxRate10AndImportDutyRate5ShouldBe1Point5() {
        List<Item> items = new ArrayList<>();
        Item item = Mockito.mock(Item.class);
        when(item.isTaxExempted()).thenReturn(false);
        when(item.isImported()).thenReturn(true);
        when(item.calculateTotalPrice()).thenReturn(10d);
        items.add(item);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(1.5, salesTaxCalculator.calculateTotalSalesTax(items), 0);
    }

    @Test
    public void totalPriceOfOneImportedPerfumeOfPrice10AtSalesTaxRate10AndImportDutyRate5ShouldBe11Point5() {
        Item item = Mockito.mock(Item.class);
        when(item.isTaxExempted()).thenReturn(false);
        when(item.isImported()).thenReturn(true);
        when(item.calculateTotalPrice()).thenReturn(10d);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(11.5, salesTaxCalculator.calculatePrice(item), 0);
    }

    @Test
    public void totalPriceOfThreeItemShouldBeSumOfTheirIndividualTotalPrice() {
        List<Item> items = new ArrayList<>();
        Item item1 = Mockito.mock(Item.class);
        when(item1.isTaxExempted()).thenReturn(true);
        when(item1.isImported()).thenReturn(false);
        when(item1.calculateTotalPrice()).thenReturn(10d);
        items.add(item1);

        Item item2 = Mockito.mock(Item.class);
        when(item2.isTaxExempted()).thenReturn(true);
        when(item2.isImported()).thenReturn(false);
        when(item2.calculateTotalPrice()).thenReturn(20d);
        items.add(item2);

        Item item3 = Mockito.mock(Item.class);
        when(item3.isTaxExempted()).thenReturn(true);
        when(item3.isImported()).thenReturn(false);
        when(item3.calculateTotalPrice()).thenReturn(30d);
        items.add(item3);

        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(60d, salesTaxCalculator.calculateTotalPrice(items), 0);
    }

    @Test
    public void shouldCalculateTotalSalesTaxOfListOfItems() {
        List<Item> items = new ArrayList<>();
        Item item1 = Mockito.mock(Item.class);
        when(item1.isTaxExempted()).thenReturn(true);
        when(item1.isImported()).thenReturn(true);
        when(item1.calculateTotalPrice()).thenReturn(10d);
        items.add(item1);

        Item item2 = Mockito.mock(Item.class);
        when(item2.isTaxExempted()).thenReturn(false);
        when(item2.isImported()).thenReturn(true);
        when(item2.calculateTotalPrice()).thenReturn(47.50);
        items.add(item2);

        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(7.65, salesTaxCalculator.calculateTotalSalesTax(items), 0);
    }

    @Test
    public void shouldCalculateTotalPriceOfListOfItems() {
        List<Item> items = new ArrayList<>();
        Item item1 = Mockito.mock(Item.class);
        when(item1.isTaxExempted()).thenReturn(true);
        when(item1.isImported()).thenReturn(true);
        when(item1.calculateTotalPrice()).thenReturn(10d);
        items.add(item1);

        Item item2 = Mockito.mock(Item.class);
        when(item2.isTaxExempted()).thenReturn(false);
        when(item2.isImported()).thenReturn(true);
        when(item2.calculateTotalPrice()).thenReturn(47.50);
        items.add(item2);

        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(10d, 5d);
        assertEquals(65.15, salesTaxCalculator.calculateTotalPrice(items), 0);
    }
}
