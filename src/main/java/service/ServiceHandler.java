package service;

import payment.Basket;
import payment.Price;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceHandler {
    private final List<Service> serviceList;

    public ServiceHandler() {
        serviceList = new ArrayList<>();
        serviceList.add(new FreeGift());
        serviceList.add(new FreeGiftLighter());
        serviceList.add(new DiscountApple());
        serviceList.add(new DiscountBentoWithDrink());
    }

    public Price getMaxDiscountPrice(Basket basket) {
        List<Price> discountPriceList = new ArrayList<>();
        for(Service service : serviceList){
            discountPriceList.add(service.getDiscountPrice(basket));
        }
        return discountPriceList.stream().max(Comparator.comparing(Price::getValue)).get();
    }
}
