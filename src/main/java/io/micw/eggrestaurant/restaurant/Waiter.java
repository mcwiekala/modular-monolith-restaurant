package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
class Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    List<Customer> customerWhoEat = new ArrayList<>();

    public Waiter(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order receiveWishFromPerson(Visitor visitor, EggType eggType) {
        Customer customer = new Customer(visitor, this); //TODO: Spring is needed
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
            customerWhoEat.add(customer);
            return true;
        } else {
            log.info("Client has gone away!");
            return false;
        }
    }

    @Scheduled(fixedRate = 3000L)
    void checkCustomer() {
        for (Customer customer : customerWhoEat) {
            if (customerHasEatenAndGoAway(customer)) {
                
            }
        }
    }

    private boolean customerHasEatenAndGoAway(Customer c) {
        return c.getIsFoodDelivered() && !c.getIsInLocal();
    }


}
