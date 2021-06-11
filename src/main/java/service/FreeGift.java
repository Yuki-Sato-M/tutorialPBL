package service;

import payment.Basket;
import payment.ItemTable;
import payment.Price;

import java.util.Map;

public class FreeGift implements Service{

    private final static int FREE_GIFT_UNIT = 11;

    @Override
    public Price getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();
        Price salesPrice = new Price(0);
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            int salesNum = entry.getValue() / FREE_GIFT_UNIT;
            Price itemPrice = entry.getKey().getItem().getPriceIncludedTax();
            salesPrice = salesPrice.add(itemPrice.mul(salesNum));
        }
        return salesPrice;
    }
}
