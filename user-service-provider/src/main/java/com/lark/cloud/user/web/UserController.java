package com.lark.cloud.user.web;

import com.lark.cloud.user.client.SysUserClient;
import com.lark.cloud.user.dto.SysUserDto;
import com.lark.cloud.user.service.SysUserService;
import com.lark.cloud.user.web.adpater.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-15 下午1:35
 */
@RestController
public class UserController implements SysUserClient {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserMapper mapper;

    @Override
    public SysUserDto getSysUser(@RequestBody SysUserDto sysUserDto) {
        return null;
    }

    @Override
    public SysUserDto insertSysUser(@RequestBody SysUserDto sysUserDto) {
        return mapper.map(sysUserService.create(mapper.map(sysUserDto)));
    }

    @Override
    public SysUserDto getById(@PathVariable Long id) {
        return mapper.map(sysUserService.selectByPk(id));
    }

    @Override
    public SysUserDto updateSysUser(@RequestBody SysUserDto sysUserDto) {
        return mapper.map(sysUserService.update(mapper.map(sysUserDto)));
    }
}
