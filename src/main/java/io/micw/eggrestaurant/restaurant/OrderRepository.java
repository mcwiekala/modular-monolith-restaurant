package io.micw.eggrestaurant.restaurant;


import java.util.UUID;

interface OrderRepository {

    void saveOrder(Order order);
    Order getOrder(UUID orderId);

}