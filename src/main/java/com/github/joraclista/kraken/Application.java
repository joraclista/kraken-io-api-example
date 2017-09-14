package com.github.joraclista.kraken;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Alisa
 * version 1.0.
 */
@Slf4j
@SpringBootApplication
@ComponentScan("com.github.joraclista.kraken")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}