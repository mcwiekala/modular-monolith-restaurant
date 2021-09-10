package io.micw.eggrestaurant.restaurant;


import java.util.UUID;

interface CustomerRepository {

    void saveCustomer(Customer customer);
    Customer getCustomer(UUID customerId);

}