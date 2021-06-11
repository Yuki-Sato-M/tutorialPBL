package service;

import payment.Basket;
import payment.Price;

interface Service {
    /**
     *
     * @param basket
     * @return 割引される金額
     */
    Price getDiscountPrice(Basket basket);
}
