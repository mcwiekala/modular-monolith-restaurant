package io.micw.eggrestaurant.cooking;

import java.util.UUID;

public interface CookOrderRepository {

    void saveOrder(CookOrder cookOrder);
    CookOrder getCookOrder(UUID orderId);

}