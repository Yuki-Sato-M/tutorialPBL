package payment;

import org.junit.jupiter.api.Test;
import service.ServiceHandler;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private Receipt receipt;
    private Basket basket;

    @Test
    void リンゴ3個ぶどう10個を買った時割引後価格1カンマ924円合計金額が1カンマ944円() {
        receipt = new Receipt();
        basket = new Basket();
        basket.add(ItemTable.APPLE, 3);
        basket.add(ItemTable.GRAPE, 10);
        String strE = "【購入したもの】" + System.lineSeparator() +
                "りんご x 3個 = 324円" + System.lineSeparator() +
                "ぶどう x 10個 = 1,620円" + System.lineSeparator() +
                "合計金額 : 1,944円" + System.lineSeparator() +
                "割引後金額 : 1,924円";

        receipt.init();
        int totalPrice = 0;
        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            if(amount > 0){
                String name = entry.getKey().getItem().getName();
                Price price = new Price(entry.getKey().getItem().getPriceIncludedTax()*amount);
                receipt.addItemLine(name, amount, price);
            }
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }
        ServiceHandler serviceHandler = new ServiceHandler();
        int discountedPrice = totalPrice - serviceHandler.getMaxDiscountPrice(basket);

        receipt.addPriceLine("合計金額", new Price(totalPrice));
        receipt.addPriceLine("割引後金額", new Price(discountedPrice));

        assertEquals(strE, receipt.toString());
    }


}