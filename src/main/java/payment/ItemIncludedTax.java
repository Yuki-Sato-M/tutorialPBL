package payment;

public class ItemIncludedTax implements Item {
    private final int id;
    private final String name;
    private final int price;

    public ItemIncludedTax(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
        return id + " : " + name + " : " + getPriceIncludedTax();
    }
}
