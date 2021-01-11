package com.github.mrcaoyc.database.document.dao.mysql;

import com.github.mrcaoyc.database.document.model.po.MySqlTableDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * mysql 表查询
 *
 * @author caoyongcheng
 */
@Mapper
public interface MysqlTableDao {

    /**
     * 获取表的数量
     *
     * @param databaseName 数据库名
     * @return 表的数量
     */
    long countTables(String databaseName);

    /**
     * 分页获取表
     *
     * @param databaseName 数据库名
     * @param pageable     分页信息
     * @return 表列表
     */
    List<MySqlTableDO> selectList(@Param("databaseName") String databaseName,
                                  @Param("pageable") Pageable pageable);

    /**
     * 查询数据库表
     *
     * @param databaseName 数据库名
     * @return 表列表
     */
    List<MySqlTableDO> selectAll(@Param("databaseName") String databaseName);
}
