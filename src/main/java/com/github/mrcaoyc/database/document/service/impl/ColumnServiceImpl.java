package com.github.mrcaoyc.database.document.service.impl;

import com.github.mrcaoyc.database.document.manager.common.DatabaseConfigurationManager;
import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.service.ColumnService;
import com.github.mrcaoyc.database.document.strategy.column.ColumnContext;
import com.github.mrcaoyc.database.document.strategy.column.ColumnStrategy;
import com.github.mrcaoyc.database.document.util.DatabaseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service
public class ColumnServiceImpl implements ColumnService {
    private final ColumnContext columnContext;
    private final DatabaseConfigurationManager databaseConfigurationManager;

    public ColumnServiceImpl(ColumnContext columnContext,
                             DatabaseConfigurationManager databaseConfigurationManager) {
        this.columnContext = columnContext;
        this.databaseConfigurationManager = databaseConfigurationManager;
    }

    @Override
    public List<ColumnDTO> listColumns(Long dataSourceConfigurationId, String tableName) {
        DatabaseConfigurationDTO databaseConfigurationDTO = databaseConfigurationManager.findById(dataSourceConfigurationId);
        if (databaseConfigurationDTO == null) {
            return null;
        }
        ColumnStrategy columnStrategy = columnContext.getStrategy(databaseConfigurationDTO.getDatabaseType());
        String databaseName = DatabaseUtils.getDatabaseNameFromUrl(databaseConfigurationDTO.getUrl());
        return columnStrategy.listColumns(databaseName, tableName);
    }
}
