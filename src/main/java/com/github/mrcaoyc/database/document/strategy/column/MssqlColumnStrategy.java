package com.github.mrcaoyc.database.document.strategy.column;

import com.github.mrcaoyc.database.document.constants.DatabaseTypeConstant;
import com.github.mrcaoyc.database.document.manager.dynamic.ColumnManager;
import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MySql表状态
 *
 * @author CaoYongCheng
 */
@Component
@ColumnHandler(DatabaseTypeConstant.MSSQL)
public class MssqlColumnStrategy implements ColumnStrategy {
    private final ColumnManager columnManager;

    public MssqlColumnStrategy(@Qualifier("mssqlColumnManager") ColumnManager columnManager) {
        this.columnManager = columnManager;
    }

    @Override
    public List<ColumnDTO> listColumns(String databaseName, String tableName) {
        return columnManager.listColumns(databaseName, tableName);
    }
}
