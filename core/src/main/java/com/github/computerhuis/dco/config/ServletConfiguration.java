package com.github.computerhuis.dco.config;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
public class ServletConfiguration {

    @Bean
    @Primary
    public DataSource dataSource(@Value("${spring.datasource.jndi-name}") final String jndiName) {
        val lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(jndiName);
    }
}
