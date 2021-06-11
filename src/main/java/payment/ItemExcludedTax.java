package payment;

public class ItemExcludedTax implements Item {
    private final int id;
    private final String name;
    private final int price;
    private final double TAX_RATE = 0.08;
    private final String category;

    public String getName() {
        return name;
    }

    public ItemExcludedTax(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    @Override
    public int getPriceIncludedTax() {
        return (int) (price * (1.0 + TAX_RATE));
    }

    @Override
    public String toString() {
        String strPrice = new Price(getPriceIncludedTax()).toString();
        return id + " : " + name + " : " + strPrice;
    }

    public String getCategory() {
        return category;
    }
}
