package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.CommonsConfiguration;
import io.micw.eggrestaurant.commons.EventBus;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonsConfiguration.class})
@EnableAutoConfiguration
class RestaurantConfiguration {

    @Bean
    CustomerEventPublisher customerEventPublisher(EventBus eventBus) {
        return new CustomerEventPublisher(eventBus);
    }

    @Bean
    MealRepository MealRepository() {
        return new InMemoryMealRepository();
    }

    @Bean
    RestaurantEventPublisher restaurantEventPublisher(EventBus eventBus) {
        return new RestaurantEventPublisher(eventBus);
    }

    @Bean
    OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

    @Bean
    MealEventHandler mealEventHandler(OrderRepository orderRepository, MealRepository mealRepository, Waiter waiter) {
        return new MealEventHandler(orderRepository, mealRepository, waiter);
    }

    @Bean
    Waiter waiter(RestaurantEventPublisher restaurantEventPublisher, OrderRepository orderRepository, CustomerRepository customerRepository, CustomerNotificationService customerNotificationService) {
        return new Waiter(restaurantEventPublisher, orderRepository, customerRepository, customerNotificationService);
    }

    @Bean
    CustomerRepository customerRepository() {
        return new InMemoryCustomerRepository();
    }

    @Bean
    CustomerNotificationService customerNotificationService(CustomerEventPublisher customerEventPublisher, CustomerRepository customerRepository) {
        return new CustomerNotificationService(customerEventPublisher, customerRepository);
    }


//    CommandLineRunner init(){
//        return args -> {
//
//        }
//    }


}
