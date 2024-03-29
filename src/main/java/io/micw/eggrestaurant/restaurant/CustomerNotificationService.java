package io.micw.eggrestaurant.restaurant;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

class CustomerNotificationService {

    CustomerEventPublisher customerEventPublisher;
    CustomerRepository customerRepository;
    List<Customer> customerWhoEat = new ArrayList<>();

    public CustomerNotificationService(CustomerEventPublisher customerEventPublisher, CustomerRepository customerRepository) {
        this.customerEventPublisher = customerEventPublisher;
        this.customerRepository = customerRepository;
    }

    void addEatingCustomer(Customer customer){
        customerWhoEat.add(customer);
    }

    @Scheduled(fixedRate = 3000L)
    void checkCustomer() {
        if(customerWhoEat.isEmpty()){
            return;
        }
        for (Customer customer : customerWhoEat) {
            if (customerHasEatenAndGoAway(customer)) {
                customerEventPublisher.publish(new MealWasEatenEvent(customer.getOrderId()));
            }
        }
    }

    private boolean customerHasEatenAndGoAway(Customer c) {
        return c.getIsFoodDelivered() && !c.getIsInLocal();
    }
}
