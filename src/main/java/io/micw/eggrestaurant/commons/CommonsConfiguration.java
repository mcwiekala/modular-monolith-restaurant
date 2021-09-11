package io.micw.eggrestaurant.commons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class CommonsConfiguration {

    @Bean
    EventBus eventBus() {
        return new EventBusImpl();
    }

}
