package com.github.computerhuis.dco.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageSourceBundles {

    private static final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    static {
        messageSource.setBasenames("classpath:/languages/messages");
    }

    // --[ GETTER ]-----------------------------------------------------------------------------------------------------
    public static String getLabel(final String key) {
        return getLabel(key, LocaleContextHolder.getLocale(), null);
    }


    public static String getLabel(final String key, final Locale locale, final Object... args) {
        return messageSource.getMessage(key, args, locale);
    }

    // --[ BEANS ]------------------------------------------------------------------------------------------------------
    @Bean
    public MessageSource messageSource() {
        return messageSource;
    }
}
