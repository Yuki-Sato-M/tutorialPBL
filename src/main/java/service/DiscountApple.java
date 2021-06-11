package service;

import payment.Basket;
import payment.ItemTable;
import payment.Price;

import java.util.Map;

public class DiscountApple implements Service{
    private final static int DISCOUNT_UNIT_APPLE = 3;
    private final static int DISCOUNT_PRICE_APPLE = 20;
    @Override
    public Price getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();

        int appleNum = itemList.get(ItemTable.APPLE);

        return new Price( DISCOUNT_PRICE_APPLE * (appleNum / DISCOUNT_UNIT_APPLE));
    }
}
