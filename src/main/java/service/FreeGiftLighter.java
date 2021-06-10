package service;

import payment.Basket;
import payment.ItemTable;

import java.util.Map;

public class FreeGiftLighter implements Service{
    private final static int FREE_GIFT_UNIT_LIGHTER = 10;

    @Override
    public int getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();

        int lighterNum = itemList.get(ItemTable.LIGHTER);
        int lighterPrice = ItemTable.LIGHTER.getItem().getPriceIncludedTax();
        int cigarettesNum = itemList.get(ItemTable.CIGARETTES);
        int mensoleCigarettesNum = itemList.get(ItemTable.MENSOLE_CIGARETTES);
        int salesNum = cigarettesNum / FREE_GIFT_UNIT_LIGHTER + mensoleCigarettesNum / FREE_GIFT_UNIT_LIGHTER;
        if (lighterNum == 0) {
            return 0;
        }
        if (lighterNum <= salesNum) {
            salesNum = lighterNum;
        }
        return lighterPrice * salesNum;
    }
}
