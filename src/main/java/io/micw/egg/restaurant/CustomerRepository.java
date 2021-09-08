package io.micw.egg.restaurant;


import java.util.UUID;

interface CustomerRepository {

    void saveCustomer(Customer customer);
    Customer getCustomer(UUID customerId);

}
