package com.quanle.config;

import com.quanle.pojo.Configuration;
import com.quanle.pojo.MappedStatement;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");

        List<Element> nodeList = new ArrayList<>();

        List<Element> selectNodes = rootElement.selectNodes("//select");
        List<Element> updateNodes = rootElement.selectNodes("//update");
        List<Element> insertNodes = rootElement.selectNodes("//insert");
        List<Element> deleteNodes = rootElement.selectNodes("//delete");
        if (selectNodes.size() > 0) {
            for (Element element : selectNodes) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String paramterType = element.attributeValue("parameterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParameterType(paramterType);
                mappedStatement.setSql(sqlText);
                mappedStatement.setSqlTab("select");
                String key = namespace + "." + id;
                configuration.getStatementMap().put(key, mappedStatement);

            }
        }
        if (updateNodes.size() > 0) {
            for (Element element : updateNodes) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String paramterType = element.attributeValue("parameterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParameterType(paramterType);
                mappedStatement.setSql(sqlText);
                mappedStatement.setSqlTab("update");
                String key = namespace + "." + id;
                configuration.getStatementMap().put(key, mappedStatement);

            }
        }
        if (insertNodes.size() > 0) {
            for (Element element : insertNodes) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String paramterType = element.attributeValue("parameterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParameterType(paramterType);
                mappedStatement.setSql(sqlText);
                mappedStatement.setSqlTab("insert");
                String key = namespace + "." + id;
                configuration.getStatementMap().put(key, mappedStatement);

            }
        }
        if (deleteNodes.size() > 0) {
            for (Element element : deleteNodes) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String paramterType = element.attributeValue("parameterType");
                String sqlText = element.getTextTrim();
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParameterType(paramterType);
                mappedStatement.setSql(sqlText);
                mappedStatement.setSqlTab("delete");
                String key = namespace + "." + id;
                configuration.getStatementMap().put(key, mappedStatement);

            }
        }

    }


}
