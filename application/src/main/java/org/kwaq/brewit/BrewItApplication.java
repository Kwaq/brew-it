package org.kwaq.brewit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BrewItApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BrewItApplication.class, args);
    }
}
