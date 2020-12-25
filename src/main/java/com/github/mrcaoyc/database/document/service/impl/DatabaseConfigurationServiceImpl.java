package com.github.mrcaoyc.database.document.service.impl;

import com.github.mrcaoyc.database.document.manager.common.DatabaseConfigurationManager;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.service.DatabaseConfigurationService;
import org.springframework.stereotype.Service;

/**
 * @author caoyongcheng
 */
@Service
public class DatabaseConfigurationServiceImpl implements DatabaseConfigurationService {
    private final DatabaseConfigurationManager databaseConfigurationManager;

    public DatabaseConfigurationServiceImpl(DatabaseConfigurationManager databaseConfigurationManager) {
        this.databaseConfigurationManager = databaseConfigurationManager;
    }

    @Override
    public void create(DatabaseConfigurationDTO databaseConfigurationDTO) {
        databaseConfigurationManager.create(databaseConfigurationDTO);
    }

    @Override
    public DatabaseConfigurationDTO findById(Long id) {
        return databaseConfigurationManager.findById(id);
    }
}
