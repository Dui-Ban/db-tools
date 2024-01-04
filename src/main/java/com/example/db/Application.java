package com.example.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.example.web"
        }
)
public class Application {

    public static void main(String[] args) {
        log.info("application start!");
        SpringApplication.run(Application.class, args);
        log.info("application start success!");
    }

}
