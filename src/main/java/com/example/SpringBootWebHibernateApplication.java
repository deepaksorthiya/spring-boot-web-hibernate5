package com.example;

import com.beust.jcommander.JCommander;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Deepak Katariya
 * @since 12-12-2019
 */
@SpringBootApplication
public class SpringBootWebHibernateApplication {

    public static void main(String[] args) {
        JCommander.newBuilder()
                .addObject(args)
                .build();
        SpringApplication.run(SpringBootWebHibernateApplication.class, args);
    }
}