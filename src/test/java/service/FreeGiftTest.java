package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.*;

class FreeGiftTest {
    @Test
    void タバコを11個買った時に割引される金額420円が返ってくる() {
        FreeGift freeGift = new FreeGift();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 11);
        int discountedPrice = freeGift.getDiscountPrice(basket);
        assertEquals(420, discountedPrice);
    }

}