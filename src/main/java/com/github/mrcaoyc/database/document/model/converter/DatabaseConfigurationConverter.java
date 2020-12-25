package com.github.mrcaoyc.database.document.model.converter;

import com.github.mrcaoyc.database.document.model.dto.DatabaseConfigurationDTO;
import com.github.mrcaoyc.database.document.model.po.DatabaseConfigurationDO;
import com.github.mrcaoyc.database.document.model.vo.DatabaseConfigurationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DatabaseConfigurationConverter {
    /**
     * DatabaseConfigurationDO List To DatabaseConfigurationDTO List
     *
     * @param source DatabaseConfigurationDO List
     * @return DatabaseConfigurationDTO List
     */
    List<DatabaseConfigurationDTO> toDatabaseConfigurationDtoList(List<DatabaseConfigurationDO> source);

    /**
     * DatabaseConfigurationDO To DatabaseConfigurationDTO
     *
     * @param source DatabaseConfigurationDO
     * @return DatabaseConfigurationDTO
     */
    DatabaseConfigurationDTO toDatabaseConfigurationDto(DatabaseConfigurationDO source);

    /**
     * DatabaseConfigurationRequest To DatabaseConfigurationDTO
     *
     * @param source DatabaseConfigurationRequest
     * @return DatabaseConfigurationDTO
     */
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    DatabaseConfigurationDTO toDatabaseConfigurationDto(DatabaseConfigurationRequest source);

    /**
     * DatabaseConfigurationDTO To DatabaseConfigurationDO
     *
     * @param source DatabaseConfigurationDTO
     * @return DatabaseConfigurationDO
     */
    DatabaseConfigurationDO toDatabaseConfigurationDo(DatabaseConfigurationDTO source);
}
