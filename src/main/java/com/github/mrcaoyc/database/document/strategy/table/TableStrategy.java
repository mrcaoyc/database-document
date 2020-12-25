package com.github.mrcaoyc.database.document.strategy.table;

import com.github.mrcaoyc.database.document.model.dto.TableDTO;

import java.util.List;

/**
 * @author CaoYongCheng
 */
public interface TableStrategy {
    /**
     * 预览时执行的策略
     *
     * @param databaseName 数据库名
     * @return 表列表
     */
    List<TableDTO> listTables(String databaseName);
}
