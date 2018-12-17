package com.lark.cloud.user.data;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2018-09-19 下午6:04
 */
@Service
public interface IService<T> {

    T selectByPk(Object pk);

    List<T> selectByPks(Collection<Object> pks);

    int countByExample(Example example);

    T selectOneByExample(Example example);

    List<T> selectByExample(Example example);

    QueryResult<T> paginateByExample(Example example, int page, int rows);

    List<T> selectByExampleAndRowBounds(Example example, RowBounds rowBounds);

    QueryResult<T> paginateByExampleAndRowBounds(Example example, RowBounds rowBounds);

    T create(T entity);

    T update(T entity);

    T updateSelective(T entity);

    int updateByExample(T entity, Example example);

    int updateByExampleSelective(T entity, Example example);

    void deleteByPk(Object pk);

    int deleteByPks(Collection<Object> pks);

    int deleteByExample(Example example);
}
