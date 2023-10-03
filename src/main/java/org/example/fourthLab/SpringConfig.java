package org.example.fourthLab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Configuration class for the Spring application context. It defines the data source, enables component scanning, and loads property sources.
 */
@Configuration
@ComponentScan("org.example.fourthLab")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    private final Environment env;

    /**
     * Constructor for SpringConfig.
     *
     * @param env The environment to access application properties.
     */
    public SpringConfig(Environment env) {
        this.env = env;
    }

    /**
     * Define a data source bean for connecting to the database.
     *
     * @return A DataSource configured with driver class name, URL, username, and password.
     */
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(env.getProperty("dataSource.url"));
        dataSource.setUsername(env.getProperty("dataSource.username"));
        dataSource.setPassword(env.getProperty("dataSource.password"));

        return dataSource;
    }


}
