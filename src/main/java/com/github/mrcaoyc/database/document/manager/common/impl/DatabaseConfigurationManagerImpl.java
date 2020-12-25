package com.github.mrcaoyc.database.document.manager.common.impl;

import com.github.mrcaoyc.database.document.dao.DatabaseConfigurationDao;
import com.github.mrcaoyc.database.document.manager.common.DatabaseConfigurationManager;
import com.github.mrcaoyc.database.document.model.converter.DatabaseConfigurationConverter;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.po.DatabaseConfigurationDO;
import com.github.mrcaoyc.database.document.model.query.DatabaseConfigurationQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoyongcheng
 */
@Service
public class DatabaseConfigurationManagerImpl implements DatabaseConfigurationManager {
    private final DatabaseConfigurationDao databaseConfigurationDao;
    private final DatabaseConfigurationConverter databaseConfigurationConverter;

    public DatabaseConfigurationManagerImpl(DatabaseConfigurationDao databaseConfigurationDao,
                                            DatabaseConfigurationConverter databaseConfigurationConverter) {
        this.databaseConfigurationDao = databaseConfigurationDao;
        this.databaseConfigurationConverter = databaseConfigurationConverter;
    }

    @Override
    public Page<DatabaseConfigurationDTO> queryList(DatabaseConfigurationQuery query, Pageable pageable) {
        long totalCount = databaseConfigurationDao.countAll(query);
        if (totalCount == 0) {
            return new PageImpl<>(new ArrayList<>(0), pageable, totalCount);
        }
        List<DatabaseConfigurationDO> databaseConfigurationDoList = databaseConfigurationDao.selectList(query, pageable);
        List<DatabaseConfigurationDTO> databaseConfigurationDtoList = databaseConfigurationConverter
                .toDatabaseConfigurationDtoList(databaseConfigurationDoList);
        return new PageImpl<>(databaseConfigurationDtoList, pageable, totalCount);
    }

    @Override
    public DatabaseConfigurationDTO findById(Long id) {
        DatabaseConfigurationDO databaseConfigurationDO = databaseConfigurationDao.findById(id);
        return databaseConfigurationConverter.toDatabaseConfigurationDto(databaseConfigurationDO);
    }

    @Override
    public void create(DatabaseConfigurationDTO databaseConfigurationDTO) {
        DatabaseConfigurationDO databaseConfigurationDO = databaseConfigurationConverter.toDatabaseConfigurationDo(databaseConfigurationDTO);
        databaseConfigurationDO.setCreateTime(System.currentTimeMillis());
        databaseConfigurationDO.setUpdateTime(System.currentTimeMillis());
        databaseConfigurationDao.insert(databaseConfigurationDO);
    }
}
