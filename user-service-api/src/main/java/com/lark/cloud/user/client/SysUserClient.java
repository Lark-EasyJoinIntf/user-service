package com.lark.cloud.user.client;

import com.lark.cloud.user.dto.SysRoleDto;
import com.lark.cloud.user.dto.SysUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-15 下午2:35
 */
@FeignClient(name = "user-service")
public interface SysUserClient {

    @GetMapping(value = "user")
    SysUserDto getByAccount(@RequestParam String account);

    @PostMapping(value = "user")
    SysUserDto insertSysUser(@RequestBody SysUserDto sysUserDto);

    @GetMapping(value = "user/{id}")
    SysUserDto getById(@PathVariable Long id);

    @PutMapping(value = "user")
    SysUserDto updateSysUser(@RequestBody SysUserDto sysUserDto);

    @GetMapping(value = "role")
    List<SysRoleDto> listRole(@RequestParam Long userId);
}
