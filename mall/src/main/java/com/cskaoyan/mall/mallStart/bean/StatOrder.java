package com.cskaoyan.mall.mallStart.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StatOrder {
    double amount;
    int orders;
    int customers;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date day;
    double pcr;
    int users;
    int products;

    public int getProducts() {
        return products;
    }

    public void setProducts(int product) {
        this.products = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public double getPcr() {
        return pcr;
    }

    public void setPcr(double pcr) {
        this.pcr = pcr;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
