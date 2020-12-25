package com.github.mrcaoyc.database.document.model.dto;

import lombok.Data;

/**
 * 数据库配置表
 *
 * @author caoyongcheng
 */
@Data
public class DatabaseConfigurationDTO {
    private Long id;
    private String name;
    private Byte databaseType;
    private String url;
    private String username;
    private String password;
    private Long createTime;
    private Long updateTime;
}
