package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemIncludedTaxTest {
    private Item item;

    @Test
    public void 商品番号5のタバコ420円の税金計算メソッドは_内税なので税込価格420円を返す () {
        item = ItemTable.CIGARETTES.getItem();
        assertEquals(420, item.getPriceIncludedTax().getValue());
    }
}