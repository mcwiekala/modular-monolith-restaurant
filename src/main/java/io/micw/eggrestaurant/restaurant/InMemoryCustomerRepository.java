package io.micw.eggrestaurant.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryCustomerRepository implements CustomerRepository {

    Map<UUID, Customer> map = new HashMap();

    @Override
    public void saveCustomer(Customer customer) {
        map.put(customer.getCustomerId(), customer);
    }

    @Override
    public Customer getCustomer(UUID orderId) {
        return map.get(orderId);
    }
}