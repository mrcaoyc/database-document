package com.github.mrcaoyc.database.document.model.vo;

import lombok.Data;

/**
 * 数据库配置表
 *
 * @author caoyongcheng
 */
@Data
public class DatabaseConfigurationRequest {
    private String name;
    private Byte databaseType;
    private String url;
    private String username;
    private String password;
}
