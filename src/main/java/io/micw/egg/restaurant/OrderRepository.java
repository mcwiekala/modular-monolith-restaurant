package io.micw.egg.restaurant;


import java.util.UUID;

interface OrderRepository {

    void saveOrder(Order order);
    Order getOrder(UUID orderId);

}