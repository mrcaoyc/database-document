package com.github.mrcaoyc.database.document.strategy.table;

import com.github.mrcaoyc.database.document.constants.DatabaseTypeConstant;
import com.github.mrcaoyc.database.document.manager.dynamic.TableManager;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MySql表状态
 *
 * @author CaoYongCheng
 */
@Component
@TableHandler(DatabaseTypeConstant.MSSQL)
public class MssqlTableStrategy implements TableStrategy {
    private final TableManager tableManager;

    public MssqlTableStrategy(@Qualifier("mssqlTableManager") TableManager tableManager) {
        this.tableManager = tableManager;
    }

    @Override
    public List<TableDTO> listTables(String databaseName) {
        return tableManager.listTables(databaseName);
    }
}
