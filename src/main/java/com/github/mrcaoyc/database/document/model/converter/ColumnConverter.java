package com.github.mrcaoyc.database.document.model.converter;

import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.po.MsSqlColumnDO;
import com.github.mrcaoyc.database.document.model.po.MySqlColumnDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author caoyongcheng
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ColumnConverter {
    /**
     * MySqlColumnDO List To ColumnDTO List
     *
     * @param source MySqlColumnDO List
     * @return ColumnDTO List
     */
    List<ColumnDTO> mySqlColumnDoList2ColumnDtoList(List<MySqlColumnDO> source);

    /**
     * MsSqlColumnDO To ColumnDTO
     *
     * @param source MsSqlColumnDO
     * @return ColumnDTO
     */
    @Mapping(target = "isNullable", expression = "java(source.getIsNullable()?\"YES\":\"NO\")")
    ColumnDTO mssqlColumnDo2ColumnDto(MsSqlColumnDO source);

    /**
     * List<MsSqlColumnDO> To List<ColumnDTO>
     *
     * @param source List<MsSqlColumnDO>
     * @return List<ColumnDTO>
     */
    List<ColumnDTO> msSqlColumnDoList2ColumnDtoList(List<MsSqlColumnDO> source);
}
