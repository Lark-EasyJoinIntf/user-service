package com.lark.cloud.user.web;

import com.lark.cloud.user.client.SysUserClient;
import com.lark.cloud.user.domain.SysUser;
import com.lark.cloud.user.dto.SysUserDto;
import com.lark.cloud.user.service.SysUserService;
import com.lark.cloud.user.web.adpater.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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
    public SysUserDto getByAccountPsd(@RequestParam String account,@RequestParam String psd)
    {
        Example example=new Example(SysUser.class);
        example.createCriteria()
                .andEqualTo("account",account)
                .andEqualTo("psd",psd);
        SysUser user=sysUserService.selectOneByExample(example);
        return mapper.map(user);
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
