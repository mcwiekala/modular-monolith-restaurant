package io.micw.eggrestaurant.wash;

import io.micw.eggrestaurant.commons.CommonsConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonsConfiguration.class})
@EnableAutoConfiguration
class WashConfiguration {



}
