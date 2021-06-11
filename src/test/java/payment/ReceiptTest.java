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
        Price totalPrice = new Price(0);
        Map<ItemTable, Integer> itemList = basket.lookInside();
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            if(amount > 0){
                String name = entry.getKey().getItem().getName();
                Price price = entry.getKey().getItem().getPriceIncludedTax().mul(amount);
                receipt.addItemLine(name, amount, price);
            }
            totalPrice = totalPrice.add(itemTable.getItem().getPriceIncludedTax().mul(amount));
        }
        ServiceHandler serviceHandler = new ServiceHandler();
        Price discountedPrice = totalPrice.add(serviceHandler.getMaxDiscountPrice(basket).mul(-1));

        receipt.addPriceLine("合計金額", totalPrice);
        receipt.addPriceLine("割引後金額", discountedPrice);

        assertEquals(strE, receipt.toString());
    }


}