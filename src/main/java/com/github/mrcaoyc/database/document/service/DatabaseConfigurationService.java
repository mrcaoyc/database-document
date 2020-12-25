package com.github.mrcaoyc.database.document.service;

import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;

/**
 * @author caoyongcheng
 */
public interface DatabaseConfigurationService {

    /**
     * 创建数据库配置信息
     *
     * @param databaseConfigurationDTO 数据库配置信息
     */
    void create(DatabaseConfigurationDTO databaseConfigurationDTO);

    /**
     * 根据Id查询数据库配置信息
     *
     * @param id 配置Id
     * @return 数据库配置信息
     */
    DatabaseConfigurationDTO findById(Long id);
}
