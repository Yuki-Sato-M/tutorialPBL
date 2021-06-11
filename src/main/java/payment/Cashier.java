package payment;

import service.ServiceHandler;

import java.util.Map;

public class Cashier {
    private final ServiceHandler serviceHandler;
    private Receipt receipt;

    public Cashier() {
        serviceHandler = new ServiceHandler();
        receipt = new Receipt();
    }

    public Price calcTotalPrice(Basket basket) {
        int totalPrice = 0;
        receipt.init();

        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();

            String name = entry.getKey().getItem().getName();
            int amount = entry.getValue();
            Price price = new Price(entry.getKey().getItem().getPriceIncludedTax()*amount);
            if(amount > 0){
                receipt.addItemLine(name, amount, price);
            }
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }

        Price discountedPrice = new Price(totalPrice - serviceHandler.getMaxDiscountPrice(basket));

        receipt.addPriceLine("合計金額", new Price(totalPrice));
        receipt.addPriceLine("割引後金額", discountedPrice);

        return discountedPrice;
    }

    public Receipt getReceipt(Basket basket) {
        int totalPrice = 0;
        receipt.init();

        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();

            String name = entry.getKey().getItem().getName();
            int amount = entry.getValue();
            Price price = new Price(entry.getKey().getItem().getPriceIncludedTax()*amount);
            if(amount > 0){
                receipt.addItemLine(name, amount, price);
            }
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }

        Price discountedPrice = new Price(totalPrice - serviceHandler.getMaxDiscountPrice(basket));

        receipt.addPriceLine("合計金額", new Price(totalPrice));
        receipt.addPriceLine("割引後金額", discountedPrice);

        return receipt;
    }
}
