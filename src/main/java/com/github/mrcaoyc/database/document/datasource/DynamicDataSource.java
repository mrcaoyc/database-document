package com.github.mrcaoyc.database.document.datasource;

import com.github.mrcaoyc.database.document.spring.SpringUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caoyongcheng
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> DATA_SOURCE_KEY = ThreadLocal.withInitial(() -> DataSourceConfig.DEFAULT_DATA_SOURCE);
    public static Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>(10);
    public static final ThreadLocal<String> DYNAMIC_DATA_SOURCE_KEY = new ThreadLocal<>();

    static {
        dataSourceMap.put("defaultDataSource", SpringUtils.getBean(DataSourceConfig.DEFAULT_DATA_SOURCE));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSource.getDataSource();
    }


    public static void setDataSource(String dataSource) {
        DynamicDataSource.DATA_SOURCE_KEY.set(dataSource);
        DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringUtils.getBean(DataSourceConfig.DYNAMIC_DATA_SOURCE);
        dynamicDataSource.afterPropertiesSet();
    }

    public static String getDataSource() {
        return DynamicDataSource.DATA_SOURCE_KEY.get();
    }

    public static void clear() {
        DynamicDataSource.DATA_SOURCE_KEY.remove();
        DynamicDataSource.DYNAMIC_DATA_SOURCE_KEY.remove();
    }

    public static void addDataSourceIfAbsent(String key, DataSourceProperties dataSourceProperties) {
        dataSourceMap.computeIfAbsent(key, k1 -> dataSourceProperties.initializeDataSourceBuilder().build());
    }

    public static void setDynamicDataSourceKey(String dynamicDataSourceKey) {
        DynamicDataSource.DYNAMIC_DATA_SOURCE_KEY.set(dynamicDataSourceKey);
    }

    public static String getDynamicDataSourceKey() {
        return DynamicDataSource.DYNAMIC_DATA_SOURCE_KEY.get();
    }
}
