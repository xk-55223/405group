package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class StatOrderBean {
    List<String> columns;
    List<StatOrder> rows;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<StatOrder> getRows() {
        return rows;
    }

    public void setRows(List<StatOrder> rows) {
        this.rows = rows;
    }
}
