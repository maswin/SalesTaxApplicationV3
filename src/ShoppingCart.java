import java.util.List;

public class ShoppingCart {
    private SalesTaxCalculator salesTaxCalculator;

    public ShoppingCart(SalesTaxCalculator salesTaxCalculator) {
        this.salesTaxCalculator = salesTaxCalculator;
    }

    public void generateReceipt(List<Item> shoppingBasket, OutputWriter outputWriter) {
        for(Item item : shoppingBasket) {
            printIndividualItemDetails(item, outputWriter);
        }
        outputWriter.println("Sales Tax - "+salesTaxCalculator.calculateTotalSalesTax(shoppingBasket));
        outputWriter.println("Total - "+salesTaxCalculator.calculateTotalPrice(shoppingBasket));
    }

    private void printIndividualItemDetails(Item item, OutputWriter outputWriter) {
        outputWriter.print(item.getQuantity()+" ");
        if(item.isImported()) {
            outputWriter.print("imported ");
        }
        outputWriter.print(item.getName()+" - ");
        outputWriter.println(salesTaxCalculator.calculatePrice(item));
    }
}
