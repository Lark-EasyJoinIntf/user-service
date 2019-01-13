package com.lark.cloud.user.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author sunyz
 * @desc
 * @create 2019-01-13 下午6:49
 */
@Setter
@Getter
@Generated
@Table(name = "sys_role")
public class SysRole {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "weight")
    private int weight;

    @Column(name = "create_time")
    private Date createTime;
}
