package payment;

public class ItemExcludedTax implements Item {
    private final int id;
    private final String name;
    private final int price;
    private final double TAX_RATE = 0.08;

    public String getName() {
        return name;
    }

    public ItemExcludedTax(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
