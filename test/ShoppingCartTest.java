import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {

    @Test
    public void shouldGenerateReceiptGivenAListOfItems() {

        Item item1 = Mockito.mock(Item.class);
        when(item1.getName()).thenReturn("Book");
        when(item1.getQuantity()).thenReturn(1);

        Item item2 = Mockito.mock(Item.class);
        when(item2.getName()).thenReturn("Food");
        when(item2.getQuantity()).thenReturn(1);
        when(item2.isImported()).thenReturn(true);

        List<Item> shoppingBasket = new ArrayList<>();
        shoppingBasket.add(item1);
        shoppingBasket.add(item2);

        SalesTaxCalculator salesTaxCalculator = Mockito.mock(SalesTaxCalculator.class);
        when(salesTaxCalculator.calculatePrice(item1)).thenReturn(10d);
        when(salesTaxCalculator.calculatePrice(item2)).thenReturn(20d);

        when(salesTaxCalculator.calculateTotalPrice(shoppingBasket)).thenReturn(30d);
        when(salesTaxCalculator.calculateTotalSalesTax(shoppingBasket)).thenReturn(5d);

        ShoppingCart shoppingCart = new ShoppingCart(salesTaxCalculator);

        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);

        shoppingCart.generateReceipt(shoppingBasket, outputWriter);

        verify(outputWriter, times(2)).print("1 ");
        verify(outputWriter).print("Book - ");
        verify(outputWriter).println(10.0);

        verify(outputWriter).print("imported ");
        verify(outputWriter).print("Food - ");
        verify(outputWriter).println(20.0);

        verify(outputWriter).println("Total - "+30.0);
        verify(outputWriter).println("Sales Tax - "+5.0);
    }


}
