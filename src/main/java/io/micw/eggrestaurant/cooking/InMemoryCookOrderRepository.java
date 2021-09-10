package io.micw.eggrestaurant.cooking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryCookOrderRepository implements CookOrderRepository {

    Map<UUID, CookOrder> map = new HashMap();

    @Override
    public void saveOrder(CookOrder cookOrder) {
        map.put(cookOrder.getCookOrderId(), cookOrder);
    }

    @Override
    public CookOrder getCookOrder(UUID cookOrderId) {
        return map.get(cookOrderId);
    }
}