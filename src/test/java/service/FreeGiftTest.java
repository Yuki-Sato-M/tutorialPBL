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

    @Test
    void タバコを21個買った時に割引される金額420円が返ってくる() {
        FreeGift freeGift = new FreeGift();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 21);
        int discountedPrice = freeGift.getDiscountPrice(basket);
        assertEquals(420, discountedPrice);
    }

    @Test
    void タバコを22個買った時に割引される金額840円が返ってくる() {
        FreeGift freeGift = new FreeGift();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 22);
        int discountedPrice = freeGift.getDiscountPrice(basket);
        assertEquals(840, discountedPrice);
    }

    @Test
    void 鮭弁当を32個買った時に割引される金額800円が返ってくる() {
        FreeGift freeGift = new FreeGift();
        Basket basket = new Basket();
        basket.add(ItemTable.SYAKEBEN, 32);
        int discountedPrice = freeGift.getDiscountPrice(basket);
        assertEquals(864, discountedPrice);
    }
}