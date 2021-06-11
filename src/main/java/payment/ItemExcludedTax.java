package payment;

public class ItemExcludedTax implements Item {
    private final int id;
    private final String name;
    private final Price price;
    private final double TAX_RATE = 0.08;

    public String getName() {
        return name;
    }

    public ItemExcludedTax(int id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public Price getPriceIncludedTax() {
        return price.mul(1.0+TAX_RATE);
    }

    @Override
    public String toString() {
        String strPrice = price.toString();
        return id + " : " + name + " : " + strPrice;
    }
}
