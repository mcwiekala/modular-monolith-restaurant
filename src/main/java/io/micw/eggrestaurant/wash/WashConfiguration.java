package io.micw.eggrestaurant.wash;

import io.micw.eggrestaurant.commons.CommonsConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonsConfiguration.class})
@EnableAutoConfiguration
class WashConfiguration {

    @Bean
    MealEatenHandler mealEatenHandler(DishWasher dishWasher, DishDeliveredEventRepository dishDeliveredEventRepository) {
        return new MealEatenHandler(dishWasher, dishDeliveredEventRepository);
    }

    @Bean
    DishWasher dishWasher(Sink sink) {
        return new DishWasher(sink);
    }

    @Bean
    DishDeliveredEventRepository dishDeliveredEventRepository(){
        return new InMemoryDishDeliveredEventRepository();
    }

    @Bean
    Sink sink(){
        return new Sink();
    }
}
