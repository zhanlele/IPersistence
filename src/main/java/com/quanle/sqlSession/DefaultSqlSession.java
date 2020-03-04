package com.quanle.sqlSession;

import com.quanle.executor.SimpleExecutor;
import com.quanle.pojo.Configuration;
import com.quanle.pojo.MappedStatement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author quanle
 * @date 2020/3/2 11:50 PM
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[] {mapperClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 底层都还是去执行JDBC代码 //根据不同情况，来调用selctList或者selectOne
                        // 准备参数 1：statmentid :sql语句的唯一标识：namespace.id= 接口全限定名.方法名
                        // 方法名：findAll
                        String methodName = method.getName();
                        String className = method.getDeclaringClass().getName();

                        String statementId = className + "." + methodName;
                        MappedStatement mappedStatement = configuration.getStatementMap().get(statementId);
                        String sqlTab = mappedStatement.getSqlTab();
                        SimpleExecutor simpleExecutor = new SimpleExecutor();
                        switch (sqlTab) {
                            case "select":
                                List<Object> query = simpleExecutor.query(configuration, mappedStatement, args);
                                Type genericReturnType = method.getGenericReturnType();
                                if (genericReturnType instanceof ParameterizedType) {
                                    return query;
                                }else if(query != null && query.size()==1){
                                    return query.get(0);
                                }else throw new RuntimeException("查询结果为空或者返回结果过多");
                            case "insert":
                                boolean insert = simpleExecutor.insert(configuration, mappedStatement, args);
                                if(insert){
                                    return 1;
                                }else {
                                    throw new RuntimeException("插入数据失败");
                                }
                            case "update":
                                boolean update = simpleExecutor.update(configuration, mappedStatement, args);
                                if(update){
                                    return 1;
                                }else {
                                    throw new RuntimeException("更新数据失败");
                                }
                            case "delete":
                                boolean delete = simpleExecutor.delete(configuration, mappedStatement, args);
                                if(delete){
                                    return 1;
                                }else {
                                    throw new RuntimeException("删除数据失败");
                                }
                            default:
                                throw new RuntimeException("Unknown execution method for: " + sqlTab);
                        }
                    }
                });
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... params) throws Exception {
        MappedStatement mappedStatement = configuration.getStatementMap().get(statementid);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        return simpleExecutor.query(configuration, mappedStatement, params);
    }

    @Override
    public <T> T selectOne(String statementid, Object... params) throws Exception {
        List<Object> objects = selectList(statementid, params);
        if (objects != null && objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }
    }
}
