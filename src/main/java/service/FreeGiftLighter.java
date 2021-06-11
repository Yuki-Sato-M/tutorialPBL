package service;

import payment.Basket;
import payment.ItemTable;
import payment.Price;

import java.util.Map;

public class FreeGiftLighter implements Service{
    private final static int FREE_GIFT_UNIT_LIGHTER = 10;

    @Override
    public Price getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();

        int lighterNum = itemList.get(ItemTable.LIGHTER);
        Price lighterPrice = ItemTable.LIGHTER.getItem().getPriceIncludedTax();
        int cigarettesNum = itemList.get(ItemTable.CIGARETTES);
        int mensoleCigarettesNum = itemList.get(ItemTable.MENSOLE_CIGARETTES);
        int salesNum = cigarettesNum / FREE_GIFT_UNIT_LIGHTER + mensoleCigarettesNum / FREE_GIFT_UNIT_LIGHTER;

        return lighterPrice.mul(Math.min(salesNum, lighterNum));
    }
}
