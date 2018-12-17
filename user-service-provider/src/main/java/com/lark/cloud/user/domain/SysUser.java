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
@Table(name = "sys_user")
public class SysUser implements Serializable {

    @Id
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "psd")
    private String psd;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "email")
    private String email;

    @Column(name = "channel")
    private String channel;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;
}
