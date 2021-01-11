package com.github.mrcaoyc.database.document.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 数据库配置表
 *
 * @author caoyongcheng
 */
@Data
public class DatabaseConfigurationRequest {
    @ApiModelProperty(value = "数据库配置名称，不是数据库连接中的名称", required = true)
    @NotBlank(message = "数据库配置名称不能为空")
    private String name;

    @ApiModelProperty(value = "数据库类型 0-MYSQL，1-MSSQL", required = true, dataType = "java.lang.Integer")
    @NotNull(message = "数据库类型不能为空")
    private Byte databaseType;

    @ApiModelProperty(value = "数据库地址", required = true)
    @NotBlank(message = "数据库地址不能为空")
    private String url;

    @ApiModelProperty(value = "数据库账号", required = true)
    @NotBlank(message = "数据库账号不能为空")
    private String username;

    @ApiModelProperty(value = "数据库密码", required = true)
    @NotBlank(message = "数据库密码不能为空")
    private String password;
}
