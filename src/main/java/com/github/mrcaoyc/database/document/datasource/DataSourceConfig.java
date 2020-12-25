package com.github.mrcaoyc.database.document.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author caoyongcheng
 */
@Configuration
public class DataSourceConfig {
    public static final String DEFAULT_DATA_SOURCE = "defaultDataSource";
    public static final String DYNAMIC_DATA_SOURCE = "dynamicDataSource";

    @Bean(DEFAULT_DATA_SOURCE)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource defaultDataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(DYNAMIC_DATA_SOURCE)
    @DependsOn({"springUtils", DEFAULT_DATA_SOURCE})
    @Primary
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(DynamicDataSource.dataSourceMap);
        return dynamicDataSource;
    }
}
