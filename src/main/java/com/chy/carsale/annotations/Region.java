package com.chy.carsale.annotations;

import java.lang.annotation.*;

/**
 * 地区注解,使用在有地区关联的实现类上。
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Region {
    String value();
}
