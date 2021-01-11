package com.github.mrcaoyc.database.document.dao.mysql;

import com.github.mrcaoyc.database.document.model.po.MySqlColumnDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper
public interface MysqlColumnDao {

    /**
     * 查询表的所有列
     *
     * @param databaseName 数据库名
     * @param tableName    表明
     * @return 列
     */
    List<MySqlColumnDO> findByDatabaseAndTable(@Param("databaseName") String databaseName, @Param("tableName") String tableName);
}
