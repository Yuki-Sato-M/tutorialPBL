package payment;

import org.junit.jupiter.api.Test;

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

}