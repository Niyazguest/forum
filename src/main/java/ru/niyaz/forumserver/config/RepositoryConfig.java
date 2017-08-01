package ru.niyaz.forumserver.config;

import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Нияз on 28.01.2017.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan("ru.niyaz.forumserver.repository")
public class RepositoryConfig {

    @Bean
    @DependsOn("liquibase")
    public SessionFactory sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.scanPackages("ru.niyaz.forumserver.entity").addProperties(getHibernateProperties());
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
    //    prop.put("hibernate.hbm2ddl.auto", "validate");
        prop.put("hibernate.connection.release_mode", "after_transaction");
        prop.put("hibernate.default_schema", "public");
        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        return prop;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/FORUMSERVER_DB");
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean(name = "liquibase")
    @DependsOn("dataSource")
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db-changelog/db-changelogs.xml");
        springLiquibase.setContexts("test, production");
        return springLiquibase;
    }
}
