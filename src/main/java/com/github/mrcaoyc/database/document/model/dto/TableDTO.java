package com.github.mrcaoyc.database.document.model.dto;

import lombok.Data;

/**
 * @author caoyongcheng
 */
@Data
public class TableDTO {
    /**
     * 表名
     */
    private String name;

    /**
     * 表描述
     */
    private String description;
}
