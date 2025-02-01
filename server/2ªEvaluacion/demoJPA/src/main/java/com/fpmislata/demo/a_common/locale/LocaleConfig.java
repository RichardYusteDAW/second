package com.fpmislata.demo.a_common.locale;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {

    @Bean
    LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.of("es"));
        return localeResolver;
    }

    // @Bean
    // LocaleChangeInterceptor localeChangeInterceptor() {
    //     LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    //     localeInterceptor.setParamName("Accept-Language");
    //     return localeInterceptor;
    // }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new CustomLocaleChangeInterceptor());
    }
}