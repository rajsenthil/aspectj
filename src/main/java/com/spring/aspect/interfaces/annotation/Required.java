package com.spring.aspect.interfaces.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (value = RetentionPolicy.RUNTIME)
@Target ( ElementType.TYPE)
public @interface Required {
    String[] values();
}
