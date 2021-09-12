package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
class Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    CustomerNotificationService customerNotificationService;

    public Waiter(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order receiveWishFromPerson(Visitor visitor, EggType eggType) {
        Customer customer = new Customer(visitor, this); //TODO: Spring is needed
        Order order = new Order(customer.getCustomerId(), eggType);
        customer.setOrderId(order.getOrderId());
        orderRepository.saveOrder(order);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(order.getOrderId(), eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return order;
    }

    public boolean deliverMeal(Meal meal) {
        UUID orderId = meal.getCustomerOrderId();

        Order order = orderRepository.getOrder(orderId);

        Customer customer = customerRepository.getCustomer(order.getCustomerId());
        if (customer.getIsInLocal()) {
            log.info("Client received food.");
            customer.receiveMeal(meal);
            customerNotificationService.addEatingCustomer(customer);
            return true;
        } else {
            log.info("Client has gone away!");
            return false;
        }
    }

    public void cleanTable(UUID orderId) {

        log.info("Waiter is cleaning table with order ID: " + orderId);
        log.info("clean... clean...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error", e);
        }

    }
}
