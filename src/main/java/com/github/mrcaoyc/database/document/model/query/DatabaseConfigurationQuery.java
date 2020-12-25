package com.github.mrcaoyc.database.document.model.query;

import lombok.Data;

/**
 * @author caoyongcheng
 */
@Data
public class DatabaseConfigurationQuery {
    /**
     * 查询的名称，模糊搜索
     */
    private String name;
}
