package com.lark.cloud.user.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyz
 * @desc
 * @create 2018-12-15 下午2:33
 */

@Setter
@Getter
@Generated
public class SysUserDto implements Serializable {

    private Long id;

    private String account;

    private String fullName;

    private String nickName;

    private String psd;

    private String sex;

    private String phone;

    private String idCard;

    private String email;

    private String channel;

    private String status;

    private Date updateTime;

    private Date createTime;

}
