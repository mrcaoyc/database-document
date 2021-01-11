package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.model.converter.DatabaseConfigurationConverter;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.vo.DatabaseConfigurationRequest;
import com.github.mrcaoyc.database.document.service.DatabaseConfigurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author caoyongcheng
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "数据库配置")
public class DatabaseConfigurationController {
    private final DatabaseConfigurationConverter databaseConfigurationConverter;
    private final DatabaseConfigurationService databaseConfigurationService;

    public DatabaseConfigurationController(DatabaseConfigurationConverter databaseConfigurationConverter,
                                           DatabaseConfigurationService databaseConfigurationService) {
        this.databaseConfigurationConverter = databaseConfigurationConverter;
        this.databaseConfigurationService = databaseConfigurationService;
    }

    @ApiOperation(value = "添加数据库配置")
    @PostMapping(value = "database-configs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> create(@RequestBody @Valid DatabaseConfigurationRequest request) {
        DatabaseConfigurationDTO databaseConfigurationDTO = databaseConfigurationConverter.toDatabaseConfigurationDto(request);
        databaseConfigurationService.create(databaseConfigurationDTO);
        return ResponseEntity.ok().build();
    }
}
