package com.github.mrcaoyc.database.document.strategy.column;

import java.lang.annotation.*;

/**
 * 列自定义注解
 *
 * @author CaoYongCheng
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ColumnHandler {
    byte value();
}
