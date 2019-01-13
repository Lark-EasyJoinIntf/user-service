package com.lark.cloud.user.service;

import com.lark.cloud.db.data.BaseService;
import com.lark.cloud.user.domain.SysUserRole;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2019-01-13 下午6:51
 */
@Service
public class SysUserRoleService extends BaseService<SysUserRole> {

    public List<SysUserRole> findByUserId(Long userId){
        Example example=new Example(SysUserRole.class);
        example.createCriteria().andEqualTo("userId",userId);
        return selectByExample(example);
    };
}
