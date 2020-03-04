package com.quanle.sqlSession;

import com.quanle.config.XMLConfigBuilder;
import com.quanle.pojo.Configuration;

import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author quanle
 * @date 2020/3/2 11:21 PM
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);
        return new DefaultSqlSessionFactory(configuration);
    }

}
