package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {
    private Basket basket;

    @Test
    public void バスケットにりんごを追加するとりんごが1個増える() {
        basket = new Basket();

        int beforeAppleNum = basket.lookInside().get(ItemTable.APPLE);
        basket.add(ItemTable.APPLE);
        int afterAppleNum = basket.lookInside().get(ItemTable.APPLE);

        assertEquals(beforeAppleNum + 1, afterAppleNum);
    }

    @Test
    public void バスケットにぶどうを追加するとぶどうが2個増える() {
        basket = new Basket();

        int beforeGrapeNum = basket.lookInside().get(ItemTable.GRAPE);
        basket.add(ItemTable.GRAPE, 2);
        int afterGrapeNum = basket.lookInside().get(ItemTable.GRAPE);

        assertEquals(beforeGrapeNum + 2, afterGrapeNum);
    }

}