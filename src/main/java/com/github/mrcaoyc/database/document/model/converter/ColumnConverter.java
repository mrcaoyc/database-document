package com.github.mrcaoyc.database.document.model.converter;

import com.github.mrcaoyc.database.document.model.dto.ColumnDTO;
import com.github.mrcaoyc.database.document.model.po.MySqlColumnDO;
import org.mapstruct.Mapper;
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
    List<ColumnDTO> toColumnDtoList(List<MySqlColumnDO> source);
}
