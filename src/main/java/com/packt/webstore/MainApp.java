package com.packt.webstore;


import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Restauracja Mateusza zaprasza Cię do skorzystania z super promocji. Użyj tego linka, aby cieszyć się z promocji -5 zł na wszystkie dania dostępne w naszym menu: http://localhost:8888/products/specialOffer?promo=pr0m0cja\n%s\n Do zobaczenia w lokalu!");
        return message;
    }
/*
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("restauracja.mateusza@gmail.com");
        mailSender.setPassword("yneptocbvmxepwhi");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
*/
}