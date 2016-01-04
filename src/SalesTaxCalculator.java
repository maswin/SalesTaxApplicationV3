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
        double salesTax = 0d;
        if(!item.isTaxExempted()) {
            salesTax += (item.calculateTotalPrice()*rateOfSalesTax)/100d;
        }
        salesTax += calculateImportDuty(item);
        salesTax = util.Math.roundTo0_05(salesTax);
        return salesTax;
    }

    private double calculateImportDuty(Item item) {
        if(item.isImported()) {
            return (item.calculateTotalPrice()*rateOfImportDuty)/100d;
        }
        return 0d;
    }

    public double calculatePrice(Item item) {
        return item.calculateTotalPrice()+calculateSalesTax(item);
    }

    public double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0d;
        for(Item item : items) {
            totalPrice += calculatePrice(item);
        }
        return totalPrice;
    }
}
