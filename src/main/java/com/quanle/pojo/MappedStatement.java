package com.quanle.pojo;

/**
 * @author quanle
 * @date 2020/3/2 11:04 PM
 */
public class MappedStatement {

    /**
     * namespace.id
     */
    private String id;
    /**
     * 返回值类型
     */
    private String resultType;
    /**
     * 参数值类型
     */
    private String parameterType;
    /**
     * 封装好的sql
     */
    private String sql;
    /**
     * sql标签
     */
    private String sqlTab;

    public String getId() {
        return id;
    }

    public MappedStatement setId(String id) {
        this.id = id;
        return this;
    }

    public String getResultType() {
        return resultType;
    }

    public MappedStatement setResultType(String resultType) {
        this.resultType = resultType;
        return this;
    }

    public String getParameterType() {
        return parameterType;
    }

    public MappedStatement setParameterType(String parameterType) {
        this.parameterType = parameterType;
        return this;
    }

    public String getSql() {
        return sql;
    }

    public MappedStatement setSql(String sql) {
        this.sql = sql;
        return this;
    }

    public String getSqlTab() {
        return sqlTab;
    }

    public MappedStatement setSqlTab(String sqlTab) {
        this.sqlTab = sqlTab;
        return this;
    }
}
