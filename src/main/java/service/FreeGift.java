package service;

import payment.Basket;
import payment.ItemTable;

import java.util.Map;

public class FreeGift implements Service{

    private final static int FREE_GIFT_UNIT = 11;

    @Override
    public int getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();
        int salesPrice = 0;
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            int salesNum = entry.getValue() / FREE_GIFT_UNIT;
            int itemPrice = entry.getKey().getItem().getPriceIncludedTax();
            salesPrice += itemPrice * salesNum;
        }
        return salesPrice;
    }
}
