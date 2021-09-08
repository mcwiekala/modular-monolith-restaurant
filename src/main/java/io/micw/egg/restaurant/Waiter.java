package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;

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
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return order;
    }

    public void deliverMeal(Meal meal) {

        UUID orderId = meal.getOrderId();
        Order order = orderRepository.getOrder(orderId);

        order.getCustomer().receiveMeal(meal);

    }
}
