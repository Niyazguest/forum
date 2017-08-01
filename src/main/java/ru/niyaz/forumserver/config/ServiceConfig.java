package ru.niyaz.forumserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.naming.InitialContext;

/**
 * Created by Нияз on 28.01.2017.
 */

@Configuration
@EnableScheduling
@ComponentScan({"ru.niyaz.forumserver.service",
        "ru.niyaz.forumserver.scheduler"})
public class ServiceConfig {

    @Bean("initialContext")
    public InitialContext initialContext() {
        try {
            return new InitialContext();
        } catch (Exception ex) {
            return null;
        }
    }
}
