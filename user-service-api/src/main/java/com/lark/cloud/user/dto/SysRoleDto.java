package com.lark.cloud.user.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author sunyz
 * @desc
 * @create 2019-01-13 下午6:45
 */
@Setter
@Getter
@Generated
public class SysRoleDto {
    private Long id;
    private String name;
    private String code;
    private int weight;
    private Date createTime;
}
