package com.cskaoyan.mall.mallStart.typehandler;

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

@MappedTypes(int[].class)
public class IntArrayTypeHandler implements TypeHandler<int[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement preparedStatement, int columnIndex, int[] ints, JdbcType jdbcType) throws SQLException {
        String jsonArray = null;
        try {
            jsonArray = objectMapper.writeValueAsString(ints);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(columnIndex, jsonArray);
    }

    @Override
    public int[] getResult(ResultSet resultSet, String columnName) throws SQLException {
        String value = resultSet.getString(columnName);
        return parseStringToIntArray(value);
    }

    @Override
    public int[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String value = resultSet.getString(columnIndex);
        return parseStringToIntArray(value);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String value = callableStatement.getString(columnIndex);
        return parseStringToIntArray(value);
    }

    private int[] parseStringToIntArray(String value) {
        int[] ints = null;
        if (value == null) {
            return ints;
        }
        try {
            ints = objectMapper.readValue(value, int[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ints;
    }
}
