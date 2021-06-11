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

        Price totalPrice = new Price(0);


        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();

            int amount = entry.getValue();
            totalPrice = totalPrice.add(itemTable.getItem().getPriceIncludedTax().mul(amount));
        }

        Price discountedPrice = totalPrice.add( serviceHandler.getMaxDiscountPrice(basket).mul(-1));
        return discountedPrice;
    }

    public Receipt getReceipt(Basket basket) {
        Price totalPrice = new Price(0);
        receipt.init();

        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();

            String name = entry.getKey().getItem().getName();
            int amount = entry.getValue();
            Price price = entry.getKey().getItem().getPriceIncludedTax().mul(amount);
            if(amount > 0){
                receipt.addItemLine(name, amount, price);
            }
            totalPrice = totalPrice.add(itemTable.getItem().getPriceIncludedTax().mul(amount));
        }

        Price discountedPrice = totalPrice.add( serviceHandler.getMaxDiscountPrice(basket).mul(-1));

        receipt.addPriceLine("合計金額", totalPrice);
        receipt.addPriceLine("割引後金額", discountedPrice);

        return receipt;
    }
}
