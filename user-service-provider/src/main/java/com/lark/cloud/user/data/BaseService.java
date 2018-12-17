package com.lark.cloud.user.data;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2018-09-19 下午5:52
 */
public abstract class BaseService<T> implements IService<T> {

    protected final Class<T> domainType = (Class)((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    protected final Field pkField;

    @Autowired
    protected TkMapper<T> mapper;

    public BaseService() {
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(this.domainType, Id.class);
        if (fields.size() != 1) {
            throw new IllegalStateException("Can't inhert BaseService [" + this.domainType.getTypeName() + "]");
        } else {
            this.pkField = (Field)fields.get(0);
        }
    }

    public TkMapper<T> getMapper() {
        return mapper;
    }

    public void setMapper(TkMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public T selectByPk(Object pk) {
        return mapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<T> selectByPks(Collection<Object> pks) {
        Example example = new Example(this.domainType);
        example.createCriteria().andIn(this.pkField.getName(), pks);
        return this.mapper.selectByExample(example);
    }

    @Override
    public int countByExample(Example example) {
        return mapper.selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Example example) {
        return mapper.selectOneByExample(example);
    }

    @Override
    public List<T> selectByExample(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public QueryResult<T> paginateByExample(Example example, int page, int rows) {
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        return this.paginateByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Example var1, RowBounds var2) {
        return mapper.selectByExampleAndRowBounds(var1, var2);
    }

    @Override
    public QueryResult<T> paginateByExampleAndRowBounds(Example example, RowBounds rowBounds) {
        int cnt = this.mapper.selectCountByExample(example);
        List data;
        if (cnt != 0) {
            data = this.mapper.selectByExampleAndRowBounds(example, rowBounds);
        } else {
            data = Collections.emptyList();
        }

        return new QueryResult((long)cnt, data);
    }

    @Override
    public T create(T entity) {
        Object pk = this._getPkValue(entity);
        if (pk == null) {
            this.mapper.insertUseGeneratedKeys(entity);
        } else {
            this.mapper.insert(entity);
        }

        return entity;
    }

    @Override
    public T update(T entity) {
        int rows = this.mapper.updateByPrimaryKey(entity);
        if (rows == 0) {
            throw new DataRetrievalFailureException("No update for [" + this.domainType.getTypeName() + "], pk:" + this._getPkValue(entity));
        } else {
            return entity;
        }
    }

    @Override
    public T updateSelective(T entity) {
        int rows = this.mapper.updateByPrimaryKeySelective(entity);
        if (rows == 0) {
            throw new DataRetrievalFailureException("No update for [" + this.domainType.getTypeName() + "], pk:" + this._getPkValue(entity));
        } else {
            Object pk = this._getPkValue(entity);
            return this.mapper.selectByPrimaryKey(pk);
        }
    }

    @Override
    public int updateByExample(T entity, Example example) {
        return this.mapper.updateByExample(entity, example);
    }

    @Override
    public int updateByExampleSelective(T entity, Example example) {
        return this.mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public void deleteByPk(Object pk) {
        int rows = this.mapper.deleteByPrimaryKey(pk);
        if (rows == 0) {
            throw new DataRetrievalFailureException("No delete for [" + this.domainType.getTypeName() + "], pk:" + pk);
        }
    }

    @Override
    public int deleteByPks(Collection<Object> pks) {
        Example example = new Example(this.domainType);
        example.createCriteria().andIn(this.pkField.getName(), pks);
        return this.mapper.deleteByExample(example);
    }

    @Override
    public int deleteByExample(Example example) {
        return mapper.deleteByExample(example);
    }

    private Object _getPkValue(T entity) {
        try {
            this.pkField.setAccessible(true);
            return this.pkField.get(entity);
        } catch (IllegalAccessException var3) {
            throw new MyBatisSystemException(var3);
        }
    }
}
