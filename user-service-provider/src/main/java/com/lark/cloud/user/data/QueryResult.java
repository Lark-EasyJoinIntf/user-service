package com.lark.cloud.user.data;

import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2018-09-19 下午6:05
 */
public class QueryResult<T> {
    public final long totalRecords;
    public final List<T> data;

    public QueryResult(long totalRecords, List<T> data) {
        this.totalRecords = totalRecords;
        this.data = data;
    }
}
