package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHandlerTest {
    @Test
    void りんご1個とみかん1個とぶどう1個とのり弁当1個のとき0円割引を返ってくる() {
        Basket basket = new Basket();
        basket.add(ItemTable.APPLE);
        basket.add(ItemTable.ORANGE);
        basket.add(ItemTable.GRAPE);
        basket.add(ItemTable.NORIBEN);
        ServiceHandler serviceHandler = new ServiceHandler();
        int discountPrice = serviceHandler.getMaxDiscountPrice(basket).getValue();
        assertEquals(0, discountPrice);
    }

    @Test
    void りんご3個とタバコ11個とライター1個とのり弁当2個とコーヒー1つとお茶1つのとき割引の最大値であるタバコ一箱420円が返ってくる() {
        Basket basket = new Basket();
        basket.add(ItemTable.APPLE, 3);
        basket.add(ItemTable.CIGARETTES, 11);
        basket.add(ItemTable.LIGHTER);
        basket.add(ItemTable.NORIBEN, 2);
        basket.add(ItemTable.COFFEE);
        basket.add(ItemTable.TEA);
        ServiceHandler serviceHandler = new ServiceHandler();
        int discountPrice = serviceHandler.getMaxDiscountPrice(basket).getValue();
        assertEquals(420, discountPrice);
    }

    @Test
    void りんご6個とタバコ10個とのり弁当2個とコーヒー1つとお茶1つのとき割引の最大値であるりんごの割引40円が返ってくる() {
        Basket basket = new Basket();
        basket.add(ItemTable.APPLE, 6);
        basket.add(ItemTable.CIGARETTES, 10);
        basket.add(ItemTable.NORIBEN, 2);
        basket.add(ItemTable.COFFEE);
        basket.add(ItemTable.TEA);
        ServiceHandler serviceHandler = new ServiceHandler();
        int discountPrice = serviceHandler.getMaxDiscountPrice(basket).getValue();
        assertEquals(40, discountPrice);
    }
}