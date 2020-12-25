package com.github.mrcaoyc.database.document.dao;

import com.github.mrcaoyc.database.document.model.po.DatabaseConfigurationDO;
import com.github.mrcaoyc.database.document.model.query.DatabaseConfigurationQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper
public interface DatabaseConfigurationDao {

    /**
     * 查询所有，计算条数
     *
     * @param query 查询参数
     * @return 返回条数
     */
    long countAll(DatabaseConfigurationQuery query);

    /**
     * 查询列表
     *
     * @param query    查询条件
     * @param pageable 分页条件
     * @return 数据库配置列表
     */
    List<DatabaseConfigurationDO> selectList(@Param("query") DatabaseConfigurationQuery query, @Param("pageable") Pageable pageable);

    /**
     * 根据Id查询配置信息
     *
     * @param id 配置Id
     * @return 配置信息
     */
    DatabaseConfigurationDO findById(Long id);

    /**
     * 插入数据库配置
     *
     * @param databaseConfigurationDO 数据库配置
     */
    void insert(DatabaseConfigurationDO databaseConfigurationDO);
}
