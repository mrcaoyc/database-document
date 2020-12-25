package com.github.mrcaoyc.database.document.controller;

import com.github.mrcaoyc.database.document.model.converter.DatabaseConfigurationConverter;
import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.vo.DatabaseConfigurationRequest;
import com.github.mrcaoyc.database.document.service.DatabaseConfigurationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyongcheng
 */
@RestController
public class DatabaseConfigurationController {
    private final DatabaseConfigurationConverter databaseConfigurationConverter;
    private final DatabaseConfigurationService databaseConfigurationService;

    public DatabaseConfigurationController(DatabaseConfigurationConverter databaseConfigurationConverter,
                                           DatabaseConfigurationService databaseConfigurationService) {
        this.databaseConfigurationConverter = databaseConfigurationConverter;
        this.databaseConfigurationService = databaseConfigurationService;
    }

    @PostMapping("database-configs")
    public HttpEntity<?> create(DatabaseConfigurationRequest request) {
        DatabaseConfigurationDTO databaseConfigurationDTO = databaseConfigurationConverter.toDatabaseConfigurationDto(request);
        databaseConfigurationService.create(databaseConfigurationDTO);
        return ResponseEntity.ok().build();
    }
}
