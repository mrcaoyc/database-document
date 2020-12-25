package com.github.mrcaoyc.database.document.strategy.column;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoyongcheng
 */
@Component
public class ColumnContext {
    private final ApplicationContext applicationContext;

    static Map<Byte, Class<ColumnStrategy>> strategyMap = new HashMap<>();

    public ColumnContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ColumnStrategy getStrategy(Byte type) {
        Class<ColumnStrategy> strategyClass = strategyMap.get(type);
        if (strategyClass == null) {
            throw new IllegalArgumentException("没有对应的列策略");
        }
        return applicationContext.getBean(strategyClass);
    }
}
