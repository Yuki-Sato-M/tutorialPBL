package service;

import org.junit.jupiter.api.Test;
import payment.Basket;
import payment.ItemTable;

import static org.junit.jupiter.api.Assertions.*;

class DiscountBentoWithDrinkTest {

    @Test
    void のり弁当1個とお茶1つで20円割引になる() {
        Basket basket = new Basket();
        DiscountBentoWithDrink discountBentoWithDrink = new DiscountBentoWithDrink();
        basket.add(ItemTable.NORIBEN);
        basket.add(ItemTable.TEA);
        int discountPrice = discountBentoWithDrink.getDiscountPrice(basket).getValue();
        assertEquals(20, discountPrice);
    }
    @Test
    void のり弁当1個と鮭弁当1個とお茶1つとコーヒー1個で40円割引になる() {
        Basket basket = new Basket();
        DiscountBentoWithDrink discountBentoWithDrink = new DiscountBentoWithDrink();
        basket.add(ItemTable.NORIBEN);
        basket.add(ItemTable.SYAKEBEN);
        basket.add(ItemTable.COFFEE);
        basket.add(ItemTable.TEA);

        int discountPrice = discountBentoWithDrink.getDiscountPrice(basket).getValue();
        assertEquals(40, discountPrice);
    }

    @Test
    void のり弁当1個と鮭弁当1個とお茶1つで20円割引になる() {
        Basket basket = new Basket();
        DiscountBentoWithDrink discountBentoWithDrink = new DiscountBentoWithDrink();
        basket.add(ItemTable.NORIBEN);
        basket.add(ItemTable.SYAKEBEN);
        basket.add(ItemTable.TEA);

        int discountPrice = discountBentoWithDrink.getDiscountPrice(basket).getValue();
        assertEquals(20, discountPrice);
    }
}