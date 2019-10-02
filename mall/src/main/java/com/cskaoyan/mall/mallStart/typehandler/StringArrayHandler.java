/*
package com.cskaoyan.mall.mallStart.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayHandler implements TypeHandler<String[]>{
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(strings);
            preparedStatement.setObject(i,s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String object = resultSet.getObject(s, String.class);
        return string2array(object);
    }

    private String[] string2array(String object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] strings = objectMapper.convertValue(object, String[].class);
        return strings;
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String object = (String) resultSet.getObject(i);
        return string2array(object);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String object = (String) callableStatement.getObject(i);
        return string2array(object);
    }
}
*/
