package payment;

public class ItemIncludedTax implements Item {
    private final int id;
    private final String name;
    private final Price price;

    public ItemIncludedTax(int id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public Price getPriceIncludedTax() {
        return this.price;
    }

    @Override
    public String toString() {
        String strPrice = getPriceIncludedTax().toString();
        return id + " : " + name + " : " + strPrice;
    }
}
