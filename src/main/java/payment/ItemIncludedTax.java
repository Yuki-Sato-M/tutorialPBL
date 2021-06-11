package payment;

public class ItemIncludedTax implements Item {
    private final int id;
    private final String name;
    private final int price;
    private final String category;

    public ItemIncludedTax(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int getPriceIncludedTax() {
        return price;
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
