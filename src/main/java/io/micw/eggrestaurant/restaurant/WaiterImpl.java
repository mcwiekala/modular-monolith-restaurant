package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
class WaiterImpl implements Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    OrderRepository orderRepository;
    CustomerRepository customerRepository;

    public WaiterImpl(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order receiveWishFromPerson(Visitor visitor, EggType eggType) {
//        Customer customer = new Customer(visitor, this, CustomerEventPublisher); TODO: Spring is needed
        Order order = new Order(customer.getCustomerId(), eggType);
        orderRepository.saveOrder(order);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(order.getOrderId(), eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return order;
    }

    public boolean deliverMeal(Meal meal) {
        //        TODO: get order
        UUID orderId = meal.getCustomerOrderId();

        Order order = orderRepository.getOrder(orderId);

        Customer customer = customerRepository.getCustomer(order.getCustomerId());
        if (customer.getIsInLocal()) {
            log.info("Client received food.");
            customer.receiveMeal(meal);
            return true;
        } else {
            log.info("Client has gone away!");
            return false;
        }
    }
}
