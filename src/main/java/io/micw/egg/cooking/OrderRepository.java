package io.micw.egg.cooking;

import java.util.UUID;

interface OrderRepository {

    void saveOrder(CookOrder cookOrder);
    CookOrder getOrder(UUID orderId);

}