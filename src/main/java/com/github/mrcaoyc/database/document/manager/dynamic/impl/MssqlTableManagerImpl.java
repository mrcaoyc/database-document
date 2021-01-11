package com.github.mrcaoyc.database.document.manager.dynamic.impl;

import com.github.mrcaoyc.database.document.dao.mssql.MssqlTableDao;
import com.github.mrcaoyc.database.document.manager.dynamic.TableManager;
import com.github.mrcaoyc.database.document.model.converter.TableConverter;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.model.po.MsSqlTableDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service("mssqlTableManager")
public class MssqlTableManagerImpl implements TableManager {
    private final MssqlTableDao mssqlTableDao;
    private final TableConverter tableConverter;

    public MssqlTableManagerImpl(MssqlTableDao mssqlTableDao, TableConverter tableConverter) {
        this.mssqlTableDao = mssqlTableDao;
        this.tableConverter = tableConverter;
    }

    @Override
    public List<TableDTO> listTables(String databaseName) {
        List<MsSqlTableDO> tableDoList = mssqlTableDao.selectAll(databaseName);
        return tableConverter.mssqlTableDoList2TableDtoList(tableDoList);
    }
}
