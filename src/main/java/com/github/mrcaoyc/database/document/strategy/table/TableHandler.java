package com.github.mrcaoyc.database.document.strategy.table;

import java.lang.annotation.*;

/**
 * 表自定义注解
 *
 * @author CaoYongCheng
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TableHandler {
    byte value();
}
