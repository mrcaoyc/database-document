package com.github.mrcaoyc.database.document.manager.dynamic.impl;

import com.github.mrcaoyc.database.document.dao.MysqlTableDao;
import com.github.mrcaoyc.database.document.manager.dynamic.TableManager;
import com.github.mrcaoyc.database.document.model.converter.TableConverter;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.model.po.MySqlTableDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Service("mysqlTableManager")
public class MysqlTableManagerImpl implements TableManager {
    private final MysqlTableDao mysqlTableDao;
    private final TableConverter tableConverter;

    public MysqlTableManagerImpl(MysqlTableDao mysqlTableDao, TableConverter tableConverter) {
        this.mysqlTableDao = mysqlTableDao;
        this.tableConverter = tableConverter;
    }

    @Override
    public List<TableDTO> listTables(String databaseName) {
        List<MySqlTableDO> tableDoList = mysqlTableDao.selectAll(databaseName);
        return tableConverter.toTableDtoList(tableDoList);
    }
}
