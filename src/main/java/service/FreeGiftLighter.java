package service;

import payment.Basket;
import payment.ItemTable;

import java.util.Map;

public class FreeGiftLighter implements Service{
    private final static int FREE_GIFT_UNIT_LIGHTER = 10;

    @Override
    public int getDiscountPrice(Basket basket) {
        Map<ItemTable, Integer> itemList = basket.lookInside();
        int salesPrice = 0;

        int lighterNum = itemList.get(ItemTable.LIGHTER);
        int lighterPrice = ItemTable.LIGHTER.getItem().getPriceIncludedTax();
        int cigarettesNum = itemList.get(ItemTable.CIGARETTES);
        int mensoleCigarettesNum = itemList.get(ItemTable.MENSOLE_CIGARETTES);
        int salesNum = cigarettesNum / FREE_GIFT_UNIT_LIGHTER + mensoleCigarettesNum / FREE_GIFT_UNIT_LIGHTER;
        if(lighterNum > 0){
            if(lighterNum > salesNum){
                salesNum = salesNum;
            }
            else{
                salesNum = lighterNum;
            }
        }
        return lighterPrice * salesNum;

//        if(cigarettesNum / FREE_GIFT_UNIT_LIGHTER > 0 && lighterNum > 0){
//            int salesNum = cigarettesNum / FREE_GIFT_UNIT_LIGHTER;
//            salesPrice += itemList.get(ItemTable.LIGHTER);
//        }
//
//        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
//            int salesNum = entry.getValue() / FREE_GIFT_UNIT;
//            int itemPrice = entry.getKey().getItem().getPriceIncludedTax();
//            salesPrice += itemPrice * salesNum;
//        }
    }
}
