package payment;

public interface Item {
    Price getPriceIncludedTax();
    int getId();
    String getName();
}
