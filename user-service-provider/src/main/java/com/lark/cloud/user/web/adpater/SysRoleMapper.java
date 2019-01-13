package com.lark.cloud.user.web.adpater;

import com.lark.cloud.user.domain.SysRole;
import com.lark.cloud.user.dto.SysRoleDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-16 上午11:01
 */
@Mapper(componentModel = "spring")
public abstract class SysRoleMapper {

    public abstract SysRoleDto map(SysRole obj);

    public abstract List<SysRoleDto> maps(List<SysRole> obj);

    public abstract SysRole map(SysRoleDto obj);

}
