package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeGiftLiterTest {
    @Test
    void タバコを10個とライターを1個買ったとき無料になるライターの金額が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 10);
        basket.add(ItemTable.LIGHTER);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(108, discountedPrice);
    }
}
