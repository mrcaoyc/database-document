package com.github.mrcaoyc.database.document.manager.dynamic.impl;

import com.github.mrcaoyc.database.document.dao.mssql.MssqlColumnDao;
import com.github.mrcaoyc.database.document.manager.dynamic.ColumnManager;
import com.github.mrcaoyc.database.document.model.converter.ColumnConverter;
import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.po.MsSqlColumnDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service("mssqlColumnManager")
public class MssqlColumnManagerImpl implements ColumnManager {
    private final ColumnConverter columnConverter;
    private final MssqlColumnDao mssqlColumnDao;

    public MssqlColumnManagerImpl(ColumnConverter columnConverter, MssqlColumnDao mssqlColumnDao) {
        this.columnConverter = columnConverter;
        this.mssqlColumnDao = mssqlColumnDao;
    }

    @Override
    public List<ColumnDTO> listColumns(String databaseName, String tableName) {
        List<MsSqlColumnDO> mysqlColumnDoList = mssqlColumnDao.findByDatabaseAndTable( tableName);
        return columnConverter.msSqlColumnDoList2ColumnDtoList(mysqlColumnDoList);
    }
}
