package com.github.mrcaoyc.database.document.strategy.table;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author CaoYongCheng
 */
@Component
public class TableHandlerProcessor implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> filePreviewStrategyMap = applicationContext.getBeansWithAnnotation(TableHandler.class);
        filePreviewStrategyMap.forEach((k, v) -> {
            Class<TableStrategy> strategy = (Class<TableStrategy>) (v.getClass());
            TableHandler filePreviewHandler = strategy.getAnnotation(TableHandler.class);
            byte type = filePreviewHandler.value();
            TableContext.strategyMap.put(type, strategy);
        });
    }
}
