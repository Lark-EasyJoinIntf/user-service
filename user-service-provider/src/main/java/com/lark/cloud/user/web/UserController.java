package com.lark.cloud.user.web;

import com.lark.cloud.user.client.SysUserClient;
import com.lark.cloud.user.domain.SysRole;
import com.lark.cloud.user.domain.SysUser;
import com.lark.cloud.user.domain.SysUserRole;
import com.lark.cloud.user.dto.SysRoleDto;
import com.lark.cloud.user.dto.SysUserDto;
import com.lark.cloud.user.service.SysRoleService;
import com.lark.cloud.user.service.SysUserRoleService;
import com.lark.cloud.user.service.SysUserService;
import com.lark.cloud.user.web.adpater.SysRoleMapper;
import com.lark.cloud.user.web.adpater.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysUserDto getByAccount(@RequestParam String account)
    {
        Example example=new Example(SysUser.class);
        example.createCriteria()
                .andEqualTo("account",account);
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

    @Override
    public List<SysRoleDto> listRole(Long userId) {
        List<SysUserRole>  userRoles=sysUserRoleService.findByUserId(userId);
        Set<Long> ids=userRoles.stream().filter(p->p.getRoleId()!=null).map(p->p.getRoleId()).collect(Collectors.toSet());
        List<SysRole> roles=sysRoleService.selectByPks(new HashSet<>(ids));
        return sysRoleMapper.maps(roles);
    }
}
