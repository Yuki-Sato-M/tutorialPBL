package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeGiftLighterTest {
    @Test
    void タバコを10個とライターを1個買ったとき無料になるライターの金額108円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 10);
        basket.add(ItemTable.LIGHTER);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(108, discountedPrice);
    }

    @Test
    void タバコを5個とメンソールタバコ5個とライターを1個買ったとき無料になるライターの金額0円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 5);
        basket.add(ItemTable.MENSOLE_CIGARETTES, 5);
        basket.add(ItemTable.LIGHTER);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(0, discountedPrice);
    }

    @Test
    void タバコを20個とライターを1個買ったとき無料になるライターの金額108円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 20);
        basket.add(ItemTable.LIGHTER);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(108, discountedPrice);
    }

    @Test
    void タバコを20個とライターを2個買ったとき無料になるライターの金額216円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 20);
        basket.add(ItemTable.LIGHTER, 2);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(216, discountedPrice);
    }

    @Test
    void タバコを10個とメンソールタバコ10個とライターを2個買ったとき無料になるライターの金額216円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 10);
        basket.add(ItemTable.MENSOLE_CIGARETTES, 10);
        basket.add(ItemTable.LIGHTER, 2);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(216, discountedPrice);
    }

    @Test
    void タバコを10個買ったとき無料になる0円が返ってくる() {
        FreeGiftLighter freeGiftLighter = new FreeGiftLighter();
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 10);
        int discountedPrice = freeGiftLighter.getDiscountPrice(basket);
        assertEquals(0, discountedPrice);
    }
}
