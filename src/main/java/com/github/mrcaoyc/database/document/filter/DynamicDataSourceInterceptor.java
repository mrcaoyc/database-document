package com.github.mrcaoyc.database.document.filter;

import com.github.mrcaoyc.database.document.datasource.DynamicDataSource;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.service.DatabaseConfigurationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caoyongcheng
 */
public class DynamicDataSourceInterceptor implements HandlerInterceptor {
    private final DatabaseConfigurationService databaseConfigurationService;

    public DynamicDataSourceInterceptor(DatabaseConfigurationService databaseConfigurationService) {
        this.databaseConfigurationService = databaseConfigurationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String dataSourceConfigId = request.getParameter("dataSourceConfigId");
        if (StringUtils.isNoneBlank(dataSourceConfigId)) {
            DatabaseConfigurationDTO databaseConfigurationDTO = databaseConfigurationService.findById(Long.parseLong(dataSourceConfigId));
            DataSourceProperties dataSourceProperties = getDataSourceProperties(databaseConfigurationDTO);
            String key = "dynamic" + databaseConfigurationDTO.getId();
            DynamicDataSource.addDataSourceIfAbsent(key, dataSourceProperties);
            DynamicDataSource.setDynamicDataSourceKey(key);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        DynamicDataSource.clear();
    }

    private DataSourceProperties getDataSourceProperties(DatabaseConfigurationDTO databaseConfigurationDTO) {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(databaseConfigurationDTO.getUrl());
        dataSourceProperties.setUsername(databaseConfigurationDTO.getUsername());
        dataSourceProperties.setPassword(databaseConfigurationDTO.getPassword());
        return dataSourceProperties;
    }
}
