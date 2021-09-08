package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;

import java.util.UUID;

class Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    OrderRepository orderRepository;

    public Waiter(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.orderRepository = orderRepository;
    }

    Order receiveWishFromPerson(Visitor visitor, EggType eggType) {
        Customer customer = new Customer(visitor, this);
        Order order = new Order(customer, eggType);
        orderRepository.saveOrder(order);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(order.getUuid(), eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return order;
    }

    public void deliverMeal(Meal meal) {

        //        TODO: get order
        UUID orderId = meal.getCustomerOrderId();
        Order order = orderRepository.getOrder(orderId);
//        order.getCustomer().receiveMeal(meal);

    }
}
