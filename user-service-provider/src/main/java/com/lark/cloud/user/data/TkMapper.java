package com.lark.cloud.user.data;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author sunyz
 * @desc
 * @create 2018-09-19 上午11:15
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}