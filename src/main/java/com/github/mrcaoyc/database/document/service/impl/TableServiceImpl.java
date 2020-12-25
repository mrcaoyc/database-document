package com.github.mrcaoyc.database.document.service.impl;

import com.github.mrcaoyc.database.document.manager.common.DatabaseConfigurationManager;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.service.TableService;
import com.github.mrcaoyc.database.document.strategy.table.TableContext;
import com.github.mrcaoyc.database.document.strategy.table.TableStrategy;
import com.github.mrcaoyc.database.document.util.DatabaseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service
public class TableServiceImpl implements TableService {
    private final DatabaseConfigurationManager databaseConfigurationManager;
    private final TableContext tableContext;

    public TableServiceImpl(DatabaseConfigurationManager databaseConfigurationManager, TableContext tableContext) {
        this.databaseConfigurationManager = databaseConfigurationManager;
        this.tableContext = tableContext;
    }


    @Override
    public List<TableDTO> listTables(Long dataSourceConfigurationId) {
        DatabaseConfigurationDTO databaseConfigurationDTO = databaseConfigurationManager.findById(dataSourceConfigurationId);
        if (databaseConfigurationDTO == null) {
            return null;
        }
        TableStrategy tableStrategy = tableContext.getStrategy(databaseConfigurationDTO.getDatabaseType());
        return tableStrategy.listTables(DatabaseUtils.getDatabaseNameFromUrl(databaseConfigurationDTO.getUrl()));
    }
}
