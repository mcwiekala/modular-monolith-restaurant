package io.micw.eggrestaurant.cooking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EggConfiguration {

    @Bean
    CookOrderRepository orderRepository(){
        return new InMemoryCookOrderRepository();
    }

//    @Bean
    EggOrderHandler eggOrderHandler(CookOrderRepository cookOrderRepository, Cook cook){
        return new EggOrderHandler(cookOrderRepository, cook);
    }

}
