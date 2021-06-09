package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemExcludedTaxTest {
    private Item item;

    @Test
    public void 商品番号1のりんご100円の税金計算メソッドは_外税なので税込価格108円を返す () {
        item = ItemTable.APPLE.getItem();
        assertEquals(108, item.getPriceIncludedTax());
    }
}
