package com.lark.cloud.user.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-15 下午1:38
 */
@Setter
@Getter
@Generated
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "create_time")
    private Date createTime;
}
