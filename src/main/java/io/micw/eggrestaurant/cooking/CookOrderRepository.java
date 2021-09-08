package io.micw.eggrestaurant.cooking;

import java.util.UUID;

interface CookOrderRepository {

    void saveOrder(CookOrder cookOrder);
    CookOrder getOrder(UUID orderId);

}