package com.github.mrcaoyc.database.document.service;


import com.github.mrcaoyc.database.document.model.dto.TableDTO;

import java.util.List;

/**
 * @author caoyongcheng
 */
public interface TableService {
    /**
     * 根据数据库配置Id，获取数据库中的表
     *
     * @param dataSourceConfigurationId 数据库配置Id
     * @return 数据库中的表
     */
    List<TableDTO> listTables(Long dataSourceConfigurationId);
}
