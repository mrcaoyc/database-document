package com.github.mrcaoyc.database.document.model.converter;

import com.github.mrcaoyc.database.document.model.dto.TableDTO;
import com.github.mrcaoyc.database.document.model.po.MySqlTableDO;
import com.github.mrcaoyc.database.document.model.vo.TableListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TableConverter {

    /**
     * MySqlTableDO To TableDTO
     *
     * @param source MySqlTableDO
     * @return TableDTO
     */
    @Mapping(target = "name", source = "tableName")
    @Mapping(target = "description", source = "tableComment")
    TableDTO toTableDto(MySqlTableDO source);

    /**
     * MySqlTableDO List To
     *
     * @param source MySqlTableDO List
     * @return TableDTO List
     */
    List<TableDTO> toTableDtoList(List<MySqlTableDO> source);

    /**
     * TableDTO List  To TableListResponse List
     *
     * @param source TableDTO List
     * @return TableListResponse List
     */
    List<TableListResponse> toTableListResponseList(List<TableDTO> source);
}
