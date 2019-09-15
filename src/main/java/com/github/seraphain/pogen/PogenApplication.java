package com.github.seraphain.pogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "classpath:application.properties", "file:configurations/application.properties" })
public class PogenApplication {

    public static void main(String[] args) {
        SpringApplication.run(PogenApplication.class, args);
    }

}
