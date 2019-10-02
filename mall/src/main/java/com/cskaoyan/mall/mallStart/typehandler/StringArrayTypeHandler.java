package com.cskaoyan.mall.mallStart.typehandler;

import com.cskaoyan.mall.mallStart.bean.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

@MappedTypes(String[].class)
public class StringArrayTypeHandler implements TypeHandler<String[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement preparedStatement, int columnIndex, String[] strings, JdbcType jdbcType) throws SQLException {
        String jsonArray = null;
        try {
            jsonArray = objectMapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(columnIndex, jsonArray);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String columnName) throws SQLException {
        String value = resultSet.getString(columnName);
        return parseStringToStringArray(value);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String value = resultSet.getString(columnIndex);
        return parseStringToStringArray(value);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String value = callableStatement.getString(columnIndex);
        return parseStringToStringArray(value);
    }

    private String[] parseStringToStringArray(String value) {
        String[] strings = null;
        if (value == null) {
            return strings;
        }
        try {
            strings = objectMapper.readValue(value, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
