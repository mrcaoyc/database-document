package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.model.converter.TableConverter;
import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.service.TableService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author caoyongcheng
 */
@RestController
public class TableController {
    private final TableConverter tableConverter;
    private final TableService tableService;

    public TableController(TableConverter tableConverter, TableService tableService) {
        this.tableConverter = tableConverter;
        this.tableService = tableService;
    }

    @GetMapping("/tables")
    public HttpEntity<?> listTables(@RequestParam Long dataSourceConfigId) {
        List<TableDTO> tableDtoList = tableService.listTables(dataSourceConfigId);
        return ResponseEntity.ok(tableConverter.toTableListResponseList(tableDtoList));
    }

}
