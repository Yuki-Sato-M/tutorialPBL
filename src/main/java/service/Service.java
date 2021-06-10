package service;

import payment.Basket;

interface Service {
    /**
     *
     * @param basket
     * @return 割引される金額
     */
    int getDiscountPrice(Basket basket);
}
