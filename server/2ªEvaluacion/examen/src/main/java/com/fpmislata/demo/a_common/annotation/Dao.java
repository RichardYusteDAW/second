package com.fpmislata.demo.a_common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Repository;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repository
public @interface Dao {
}