package com.github.mrcaoyc.database.document.aspect;

import com.github.mrcaoyc.database.document.datasource.DataSourceConfig;
import com.github.mrcaoyc.database.document.datasource.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 数据源切面
 *
 * @author caoyongcheng
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    @Pointcut(value = "execution(public * com.github.mrcaoyc.database.document.manager.common..*(..))")
    public void defaultDataSourcePointCut() {
    }

    @Before("defaultDataSourcePointCut()")
    public void beforeDefaultDataSource() {
        DynamicDataSource.setDataSource(DataSourceConfig.DEFAULT_DATA_SOURCE);
    }

    @Pointcut(value = "execution(public * com.github.mrcaoyc.database.document.manager.dynamic..*(..))")
    public void dynamicDataSourcePointCut() {
    }

    @Before("dynamicDataSourcePointCut()")
    public void beforeDynamicDataSource() {
        if (DynamicDataSource.getDynamicDataSourceKey() == null) {
            log.error("缺少动态数据源配置");
        }
        DynamicDataSource.setDataSource(DynamicDataSource.getDynamicDataSourceKey());
    }
}
