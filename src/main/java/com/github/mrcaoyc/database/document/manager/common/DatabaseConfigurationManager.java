package com.github.mrcaoyc.database.document.manager.common;

import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.query.DatabaseConfigurationQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 数据库文档Manager
 *
 * @author caoyongcheng
 */
public interface DatabaseConfigurationManager {
    /**
     * 分页查询数据库配置信息
     *
     * @param query    查询参数
     * @param pageable 分页参数
     * @return 数据库配置信息
     */
    Page<DatabaseConfigurationDTO> queryList(DatabaseConfigurationQuery query, Pageable pageable);

    /**
     * 根据Id查询数据库配置信息
     *
     * @param id 配置Id
     * @return 数据库配置信息
     */
    DatabaseConfigurationDTO findById(Long id);

    /**
     * 创建数据库配置信息
     *
     * @param databaseConfigurationDTO 数据库配置信息
     */
    void create(DatabaseConfigurationDTO databaseConfigurationDTO);
}
