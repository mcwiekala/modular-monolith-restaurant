package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.CommonsConfiguration;
import io.micw.eggrestaurant.commons.EventBus;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonsConfiguration.class})
@EnableAutoConfiguration
class CookingConfiguration {

    @Bean
    CookOrderRepository cookOrderRepository() {
        return new InMemoryCookOrderRepository();
    }

    @Bean
    CookingEventPublisher cookingEventPublisher(EventBus eventBus) {
        return new CookingEventPublisher(eventBus);
    }

    @Bean
    Cook cook(CookingEventPublisher cookingEventPublisher){
        return new Cook(cookingEventPublisher);
    }

    @Bean
    EggOrderHandler eggOrderHandler(CookOrderRepository cookOrderRepository, Cook cook){
        return new EggOrderHandler(cookOrderRepository, cook);
    }

}
