package io.micw.egg.cooking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryOrderRepository implements OrderRepository {

    Map<UUID, CookOrder> map = new HashMap();

    @Override
    public void saveOrder(CookOrder cookOrder) {
        map.put(cookOrder.getOrderId(), cookOrder);
    }

    @Override
    public CookOrder getOrder(UUID orderId) {
        return map.get(orderId);
    }
}