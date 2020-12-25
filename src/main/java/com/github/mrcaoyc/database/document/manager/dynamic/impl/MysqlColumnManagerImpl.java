package com.github.mrcaoyc.database.document.manager.dynamic.impl;

import com.github.mrcaoyc.database.document.dao.MysqlColumnDao;
import com.github.mrcaoyc.database.document.manager.dynamic.ColumnManager;
import com.github.mrcaoyc.database.document.model.converter.ColumnConverter;
import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.po.MySqlColumnDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service("mysqlColumnManager")
public class MysqlColumnManagerImpl implements ColumnManager {
    private final ColumnConverter columnConverter;
    private final MysqlColumnDao mysqlColumnDao;

    public MysqlColumnManagerImpl(ColumnConverter columnConverter, MysqlColumnDao mysqlColumnDao) {
        this.columnConverter = columnConverter;
        this.mysqlColumnDao = mysqlColumnDao;
    }

    @Override
    public List<ColumnDTO> listColumns(String databaseName, String tableName) {
        List<MySqlColumnDO> mysqlColumnDoList = mysqlColumnDao.findByDatabaseAndTable(databaseName, tableName);
        return columnConverter.toColumnDtoList(mysqlColumnDoList);
    }
}
