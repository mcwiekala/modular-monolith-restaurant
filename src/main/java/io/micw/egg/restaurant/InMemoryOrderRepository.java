package io.micw.egg.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryOrderRepository implements OrderRepository {

    Map<UUID, Order> map = new HashMap();

    @Override
    public void saveOrder(Order order) {
        map.put(order.getUuid(), order);
    }

    @Override
    public Order getOrder(UUID orderId) {
        return map.get(orderId);
    }
}