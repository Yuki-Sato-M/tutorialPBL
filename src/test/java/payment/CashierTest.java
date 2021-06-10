package payment;

import org.junit.jupiter.api.Test;
import service.ServiceHandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CashierTest {
    private Cashier cashier;

    @Test
    public void 何も買わないとき合計金額が0円になる () {
        cashier = new Cashier();
        String str = cashier.calcTotalPrice(new Basket()).toString();
        assertTrue(str.matches(".*0円"));

    }

    @Test
    public void タバコ２つとぶどう4つを購入した時_合計金額が1488円になる () {
        Basket basket = new Basket();
        basket.add(ItemTable.CIGARETTES, 2);
        basket.add(ItemTable.GRAPE, 4);
        cashier = new Cashier();
        assertEquals("1,488円", cashier.calcTotalPrice(basket).toString());
    }

    @Test
    void りんご6個とタバコ10個とのり弁当2個とコーヒー1つとお茶1つのとき割引の最大値であるりんごの割引40円が返ってくる() {
        Basket basket = new Basket();
        basket.add(ItemTable.APPLE, 6);
        basket.add(ItemTable.CIGARETTES, 10);
        basket.add(ItemTable.NORIBEN, 2);
        basket.add(ItemTable.COFFEE);
        basket.add(ItemTable.TEA);
        cashier = new Cashier();
        Price discountedPrice = cashier.calcTotalPrice(basket);
        assertEquals("5,758円", discountedPrice.toString());
    }

}