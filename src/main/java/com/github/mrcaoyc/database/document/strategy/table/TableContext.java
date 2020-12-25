package com.github.mrcaoyc.database.document.strategy.table;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyongcheng
 */
@Component
public class TableContext {
    private final ApplicationContext applicationContext;

    static Map<Byte, Class<TableStrategy>> strategyMap = new HashMap<>();

    public TableContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public TableStrategy getStrategy(Byte type) {
        Class<TableStrategy> filePreviewStrategyClass = strategyMap.get(type);
        if (filePreviewStrategyClass == null) {
            throw new IllegalArgumentException("没有对应的表策略");
        }
        return applicationContext.getBean(filePreviewStrategyClass);
    }
}
