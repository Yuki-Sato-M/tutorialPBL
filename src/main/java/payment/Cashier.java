package payment;

import service.ServiceHandler;

import java.util.Map;

public class Cashier {
    private final ServiceHandler serviceHandler;

    public Cashier() {
        serviceHandler = new ServiceHandler();
    }

    public Price calcTotalPrice(Basket basket) {
        int totalPrice = 0;
        Map<ItemTable, Integer> itemList = basket.lookInside();

        System.out.println();
        System.out.println("【購入したもの】");
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            if(amount > 0){
                System.out.println(entry.getKey().getItem().getName()+" x "+amount+"個"+" = "+new Price(entry.getKey().getItem().getPriceIncludedTax()*amount));
            }
            totalPrice += itemTable.getItem().getPriceIncludedTax() * amount;
        }
        System.out.println("合計金額 : "+new Price(totalPrice));
        int discountedPrice = totalPrice - serviceHandler.getMaxDiscountPrice(basket);

        return new Price(discountedPrice);
    }
}
