package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;

import java.util.UUID;

class WaiterImpl implements Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    OrderRepository orderRepository;
    MealRepository mealRepository;

    public WaiterImpl(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.orderRepository = orderRepository;
    }

    public Order receiveWishFromPerson(Visitor visitor, EggType eggType) {
        Customer customer = new Customer(visitor, this);
        Order order = new Order(customer.getCustomerId(), eggType);
        orderRepository.saveOrder(order);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(order.getUuid(), eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return order;
    }

    public boolean deliverMeal(Meal meal) {
        //        TODO: get order
        UUID orderId = meal.getCustomerOrderId();
        Order order = orderRepository.getOrder(orderId);
//        Customer customer = customer order.getCustomerId();
//        customer.receiveMeal(meal);
        return true;
    }
}
