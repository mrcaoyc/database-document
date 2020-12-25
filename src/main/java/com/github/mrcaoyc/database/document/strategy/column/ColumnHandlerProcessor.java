package com.github.mrcaoyc.database.document.strategy.column;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author CaoYongCheng
 */
@Component
public class ColumnHandlerProcessor implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> filePreviewStrategyMap = applicationContext.getBeansWithAnnotation(ColumnHandler.class);
        filePreviewStrategyMap.forEach((k, v) -> {
            Class<ColumnStrategy> strategy = (Class<ColumnStrategy>) (v.getClass());
            ColumnHandler filePreviewHandler = strategy.getAnnotation(ColumnHandler.class);
            byte type = filePreviewHandler.value();
            ColumnContext.strategyMap.put(type, strategy);
        });
    }
}
