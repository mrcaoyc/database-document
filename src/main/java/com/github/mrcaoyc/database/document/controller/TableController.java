package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.model.converter.TableConverter;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.model.vo.TableListResponse;
import com.github.mrcaoyc.database.document.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Api(tags = "数据库表")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TableController {
    private final TableConverter tableConverter;
    private final TableService tableService;

    public TableController(TableConverter tableConverter, TableService tableService) {
        this.tableConverter = tableConverter;
        this.tableService = tableService;
    }

    @ApiOperation(value = "获取数据库中的表列表", response = TableListResponse.class, responseContainer = "list")
    @ApiImplicitParam(name = "dataSourceConfigId", value = "数据库配置Id")
    @GetMapping("/tables")
    public HttpEntity<?> listTables(@RequestParam Long dataSourceConfigId) {
        List<TableDTO> tableDtoList = tableService.listTables(dataSourceConfigId);
        return ResponseEntity.ok(tableConverter.toTableListResponseList(tableDtoList));
    }

}
