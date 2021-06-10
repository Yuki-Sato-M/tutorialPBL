package payment;

import service.ServiceHandler;

import java.util.Map;

public class Cashier {
    private final ServiceHandler serviceHandler;

    public Cashier() {
        serviceHandler = new ServiceHandler();
    }

    public Price calcTotalPrice(Basket basket) {
        int totalPrice = 0;
        Map<ItemTable, Integer> itemList = basket.lookInside();

        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }

        int discountedPrice = totalPrice - serviceHandler.getMaxDiscountPrice(basket);

        return new Price(discountedPrice);
    }
}
