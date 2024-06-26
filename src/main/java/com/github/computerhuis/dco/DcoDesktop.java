package com.github.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DcoDesktop {

    public static void main(final String... args) {
        SpringApplication.run(DcoDesktop.class, args);
    }
}
