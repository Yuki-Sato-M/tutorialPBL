package service;

import payment.Basket;
import payment.ItemTable;

import java.util.Map;

public class DiscountApple implements Service{
    private final static int DISCOUNT_UNIT_APPLE = 3;
    private final static int DISCOUNT_PRICE_APPLE = 20;
    @Override
    public int getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();

        int appleNum = itemList.get(ItemTable.APPLE);

        return DISCOUNT_PRICE_APPLE * (appleNum / DISCOUNT_UNIT_APPLE);
    }
}
