package ru.niyaz.forumserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Нияз on 28.01.2017.
 */

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class, SecurityConfig.class, WebSocketConfig.class, FactoryConfig.class, AdditionalConfig.class})
public class AppConfig {
}
