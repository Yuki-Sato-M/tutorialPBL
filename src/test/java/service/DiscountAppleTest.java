package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.*;

class DiscountAppleTest {
    @Test
    void りんご1個100円のところ3個で20円割引になる() {
        Basket basket = new Basket();
        DiscountApple discountApple = new DiscountApple();
        basket.add(ItemTable.APPLE, 3);
        int discountPrice = discountApple.getDiscountPrice(basket).getValue();
        assertEquals(20, discountPrice);
    }

    @Test
    void りんご1個100円のところ7個で40円割引になる() {
        Basket basket = new Basket();
        DiscountApple discountApple = new DiscountApple();
        basket.add(ItemTable.APPLE, 7);
        int discountPrice = discountApple.getDiscountPrice(basket).getValue();
        assertEquals(40, discountPrice);
    }

    @Test
    void りんご1個100円のところ2個で0円割引になる() {
        Basket basket = new Basket();
        DiscountApple discountApple = new DiscountApple();
        basket.add(ItemTable.APPLE, 2);
        int discountPrice = discountApple.getDiscountPrice(basket).getValue();
        assertEquals(0, discountPrice);
    }
}