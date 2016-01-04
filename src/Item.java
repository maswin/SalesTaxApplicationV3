public class Item {
    private final String name;
    private final double price;
    private final int quantity;
    private Category category;

    public Item(String name, double price, int quantity, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public double calculateTotalPrice() {
        return price*quantity;
    }

    public boolean isTaxExempted() {
        return category.isTaxExempted();
    }
}
