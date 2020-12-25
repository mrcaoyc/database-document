package com.github.mrcaoyc.database.document.manager.dynamic;

import com.github.mrcaoyc.database.document.model.dto.TableDTO;

import java.util.List;

/**
 * 表管理
 *
 * @author caoyongcheng
 */
public interface TableManager {
    /**
     * 获取表列表
     *
     * @param databaseName 数据库名
     * @return 表列表
     */
    List<TableDTO> listTables(String databaseName);
}
