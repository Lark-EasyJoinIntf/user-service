package com.lark.cloud.user.web.adpater;

import com.lark.cloud.user.domain.SysUser;
import com.lark.cloud.user.dto.SysUserDto;
import org.mapstruct.Mapper;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-16 上午11:01
 */
@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract SysUserDto map(SysUser obj);

    public abstract SysUser map(SysUserDto obj);

}
