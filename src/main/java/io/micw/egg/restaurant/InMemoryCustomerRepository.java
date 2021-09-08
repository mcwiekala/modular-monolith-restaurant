package io.micw.egg.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryCustomerRepository implements CustomerRepository {

    Map<UUID, Customer> map = new HashMap();

    @Override
    public void saveCustomer(Customer Customer) {
        map.put(Customer.getUuid(), Customer);
    }

    @Override
    public Customer getCustomer(UUID customerId) {
        return map.get(customerId);
    }
}