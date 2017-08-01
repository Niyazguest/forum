package ru.niyaz.forumserver.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Нияз on 05.02.2017.
 */

@Configuration
public class AdditionalConfig {

    @Bean
    public static PropertyPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("properties/common.properties"));
        return placeholderConfigurer;
    }
}
