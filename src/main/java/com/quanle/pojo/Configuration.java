package com.quanle.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

/**
 * @author quanle
 * @date 2020/3/2 10:38 PM
 */
public class Configuration {

    /**
     * 数据库配置
     */
    private DataSource dataSource;
    /**
     * sql封装对象，key为namespace.id，value为封装对象
     */
    private Map<String, MappedStatement> statementMap = new HashMap<String, MappedStatement>();

    /**
     * 无参构造器
     */
    public Configuration() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Configuration setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public Map<String, MappedStatement> getStatementMap() {
        return statementMap;
    }

    public Configuration setStatementMap(Map<String, MappedStatement> statementMap) {
        this.statementMap = statementMap;
        return this;
    }
}
