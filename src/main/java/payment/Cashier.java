package payment;

import java.util.Map;

public class Cashier {

    public Price calcTotalPrice(Basket basket) {
        int totalPrice = 0;
        Map<ItemTable, Integer> itemList = basket.lookInside();

        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }

        return new Price(totalPrice);
    }
}
