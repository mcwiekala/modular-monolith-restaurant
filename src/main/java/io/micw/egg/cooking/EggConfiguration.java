package io.micw.egg.cooking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EggConfiguration {

    @Bean
    OrderRepository orderRepository(){
        return new InMemoryOrderRepository();
    }

    @Bean
    EggOrderHandler eggOrderHandler(OrderRepository orderRepository){
        return new EggOrderHandler(orderRepository);
    }

}
