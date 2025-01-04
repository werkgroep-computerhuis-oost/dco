package com.github.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
public class WerkplaatsServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        log.info("Initializing the application through WerkplaatsServletInitializer...");
        return application.sources(WerkplaatsServletInitializer.class);
    }
}
