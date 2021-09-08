package io.micw.egg.restaurant;

class Waiter {

    RestaurantEventPublisher restaurantEventPublisher;
    CustomerRepository customerRepository;

    void getOrder(Person person, Order order) {
        Customer customer = new Customer(person, order, this);
        customerRepository.saveCustomer(customer);
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(order.eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
    }

}
