package com.quanle.sqlSession;

import java.util.List;

/**
 * @author quanle
 * @date 2020/3/2 11:49 PM
 */
public interface SqlSession {

    /**
     * 代理实现类
     */
    public <T> T getMapper(Class<T> mapperClass);

    public <E> List<E> selectList(String statementid,Object... params) throws Exception;
    public <T> T selectOne(String statementid,Object... params) throws Exception;
}
