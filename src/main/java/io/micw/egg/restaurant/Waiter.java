package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;

class Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    CustomerRepository customerRepository;

    public Waiter(RestaurantEventPublisher restaurantEventPublisher, CustomerRepository customerRepository) {
        this.restaurantEventPublisher = restaurantEventPublisher;
        this.customerRepository = customerRepository;
    }

    Customer createOrder(Person person, EggType eggType) {
        Order order = new Order(eggType);
        Customer customer = new Customer(person, order, this);
        customerRepository.saveCustomer(customer);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
        return customer;
    }

}
