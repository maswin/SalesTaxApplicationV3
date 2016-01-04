import java.util.List;

public class SalesTaxCalculator {
    private final double rateOfSalesTax;
    private final double rateOfImportDuty;

    public SalesTaxCalculator(double rateOfSalesTax, double rateOfImportDuty) {
        this.rateOfSalesTax = rateOfSalesTax;
        this.rateOfImportDuty = rateOfImportDuty;
    }

    public double calculateTotalSalesTax(List<Item> items) {
        double totalSalesTax = 0d;
        for(Item item : items) {
            totalSalesTax += calculateSalesTax(item);
        }
        return totalSalesTax;
    }

    private double calculateSalesTax(Item item) {
        if(!item.isTaxExempted()) {
            return (item.calculateTotalPrice()*rateOfSalesTax)/100d;
        }
        return 0d;
    }
}
