package com.github.mrcaoyc.database.document.model.po;

import lombok.Data;

/**
 * @author caoyongcheng
 */
@Data
public class MsSqlTableDO {
    /**
     * 表名
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;
}
