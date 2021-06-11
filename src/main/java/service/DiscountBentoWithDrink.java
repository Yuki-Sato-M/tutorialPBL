package service;

import payment.Basket;
import payment.ItemTable;
import payment.Price;

import java.util.Map;

public class DiscountBentoWithDrink implements Service{
    private final static int DISCOUNT_PRICE_PAIR = 20;
    @Override
    public Price getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();

        int bentoNum = itemList.get(ItemTable.NORIBEN) + itemList.get(ItemTable.SYAKEBEN);
        int drinkNum = itemList.get(ItemTable.COFFEE) + itemList.get(ItemTable.TEA);

        return new Price(DISCOUNT_PRICE_PAIR * Math.min(bentoNum, drinkNum));
    }
}
