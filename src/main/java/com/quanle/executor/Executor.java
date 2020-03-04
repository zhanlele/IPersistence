package com.quanle.executor;

import com.quanle.pojo.Configuration;
import com.quanle.pojo.MappedStatement;

import java.util.List;

/**
 * @author quanle
 * @date 2020/3/3 12:23 AM
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws
            Exception;

    public boolean update(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    public boolean insert(Configuration configuration,MappedStatement mappedStatement, Object... params) throws Exception;

    public boolean delete(Configuration configuration,MappedStatement mappedStatement,Object... params) throws Exception;
}
