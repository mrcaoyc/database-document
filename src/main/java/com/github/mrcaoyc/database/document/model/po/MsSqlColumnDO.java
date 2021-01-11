package com.github.mrcaoyc.database.document.model.po;

import lombok.Data;

/**
 * mysql 列
 *
 * @author caoyongcheng
 */
@Data
public class MsSqlColumnDO {
    private String columnName;
    private String columnType;
    private Boolean isNullable;
    private Object columnDefault;
    private String columnComment;
}
