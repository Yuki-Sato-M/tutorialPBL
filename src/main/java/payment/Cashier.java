package payment;

import service.ServiceHandler;

import java.util.Map;

public class Cashier {
    private final ServiceHandler serviceHandler;

    public Cashier() {
        serviceHandler = new ServiceHandler();
    }

    public Price calcTotalPrice(Basket basket) {
        Price totalPrice = new Price(0);
        Map<ItemTable, Integer> itemList = basket.lookInside();

        System.out.println();
        System.out.println("【購入したもの】");
        for (Map.Entry<ItemTable, Integer> entry : itemList.entrySet()) {
            ItemTable itemTable = entry.getKey();
            int amount = entry.getValue();
            if(amount > 0){
                System.out.println(entry.getKey().getItem().getName()+" x "+amount+"個"+" = "+entry.getKey().getItem().getPriceIncludedTax().mul(amount));
            }
            totalPrice = totalPrice.add(itemTable.getItem().getPriceIncludedTax().mul(amount));
        }
        System.out.println("合計金額 : "+totalPrice);
        Price discountedPrice = totalPrice.add( serviceHandler.getMaxDiscountPrice(basket).mul(-1));

        return discountedPrice;
    }
}
