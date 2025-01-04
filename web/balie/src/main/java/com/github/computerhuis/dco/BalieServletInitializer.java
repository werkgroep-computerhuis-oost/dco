package com.github.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
public class BalieServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        log.info("Initializing the application through BalieServletInitializer...");
        return application.sources(BalieServletInitializer.class);
    }
}
