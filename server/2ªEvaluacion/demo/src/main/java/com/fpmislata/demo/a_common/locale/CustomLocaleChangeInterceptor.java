package com.fpmislata.demo.a_common.locale;

import java.util.Locale;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler)
            throws ServletException {

        String lang = request.getHeader("Accept-Language");
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : Locale.getDefault();

        LanguageUtils.setCurrentLocale(locale);

        return super.preHandle(request, response, handler);
    }
}