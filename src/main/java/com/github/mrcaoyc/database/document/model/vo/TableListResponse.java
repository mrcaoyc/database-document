package com.github.mrcaoyc.database.document.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表列表显示
 *
 * @author caoyongcheng
 */
@Data
public class TableListResponse {
    @ApiModelProperty(value = "表名")
    private String name;

    @ApiModelProperty(value = "表描述信息")
    private String description;
}
