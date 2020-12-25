package com.github.mrcaoyc.database.document.service;

import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;

import java.util.List;

/**
 * @author caoyongcheng
 */
public interface ColumnService {
    /**
     * 根据数据库配置Id，获取数据库中的表
     *
     * @param dataSourceConfigurationId 数据库配置Id
     * @param tableName                 表名
     * @return 数据库中的表
     */
    List<ColumnDTO> listColumns(Long dataSourceConfigurationId, String tableName);
}
