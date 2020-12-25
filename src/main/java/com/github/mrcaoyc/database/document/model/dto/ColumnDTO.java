package com.github.mrcaoyc.database.document.model.dto;

import lombok.Data;

/**
 * 列
 *
 * @author caoyongcheng
 */
@Data
public class ColumnDTO {
    private String columnName;
    private String columnType;
    private String isNullable;
    private Object columnDefault;
    private String columnComment;
}
