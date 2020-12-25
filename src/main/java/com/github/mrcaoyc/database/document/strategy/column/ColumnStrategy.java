package com.github.mrcaoyc.database.document.strategy.column;


import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;

import java.util.List;

/**
 * @author CaoYongCheng
 */
public interface ColumnStrategy {
    /**
     * 获取表的列表
     *
     * @param databaseName 数据库名
     * @param tableName    表明
     * @return 列
     */
    List<ColumnDTO> listColumns(String databaseName, String tableName);
}
