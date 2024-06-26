package com.github.computerhuis.dco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class ApplicationWebMvcConfigurer implements WebMvcConfigurer {

    private static final int CACHE_PERIOD = 3600;

    // --[ RESOURCES ]--------------------------------------------------------------------------------------------------
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
            .addResourceLocations("classpath:/assets/")
            .setCachePeriod(CACHE_PERIOD);
        registry.addResourceHandler("/favicon.ico")
            .addResourceLocations("classpath:/assets/favicons/favicon.ico")
            .setCachePeriod(CACHE_PERIOD);
    }
}
