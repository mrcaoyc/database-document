package com.github.mrcaoyc.database.document.dao.mssql;

import com.github.mrcaoyc.database.document.model.po.MsSqlColumnDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper
public interface MssqlColumnDao {

    /**
     * 查询表的所有列
     *
     * @param tableName    表明
     * @return 列
     */
    List<MsSqlColumnDO> findByDatabaseAndTable(@Param("tableName") String tableName);
}
