package com.packt.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by dgrudzinski on 2017-11-09.
 */

@EnableJpaRepositories(basePackages = {"com.packt.webstore.domain"})
@EntityScan(basePackages = {"com.packt.webstore.domain.entity"})
@SpringBootApplication
@ImportResource("classpath:security-context.xml")
@EnableWebSecurity(debug = true)
public class MainApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}