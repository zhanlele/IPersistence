package com.quanle.sqlSession;

import com.quanle.pojo.Configuration;

/**
 * @author quanle
 * @date 2020/3/2 11:40 PM
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
