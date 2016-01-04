public class Item {
    private final String name;
    private final double price;
    private final int quantity;
    private Category category;
    private boolean isImported;

    public Item(String name, double price, int quantity, Category category, boolean isImported) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.isImported = isImported;
    }

    public double calculateTotalPrice() {
        return price*quantity;
    }

    public boolean isTaxExempted() {
        return category.isTaxExempted();
    }

    public boolean isImported() {
        return isImported;
    }
}
