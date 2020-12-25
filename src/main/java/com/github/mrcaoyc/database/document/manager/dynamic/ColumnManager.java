package com.github.mrcaoyc.database.document.manager.dynamic;

import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;

import java.util.List;

/**
 * @author caoyongcheng
 */
public interface ColumnManager {
    /**
     * 获取表的列
     *
     * @param databaseName 数据库名
     * @param tableName    表明
     * @return 表的列
     */
    List<ColumnDTO> listColumns(String databaseName, String tableName);
}
