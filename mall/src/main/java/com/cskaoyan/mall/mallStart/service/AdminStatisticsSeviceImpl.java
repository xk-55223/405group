package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Order;
import com.cskaoyan.mall.mallStart.mapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.AdminStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@Service
public class AdminStatisticsSeviceImpl implements AdminStatisticsSevice{
    @Autowired
    AdminStatisticsMapper adminStatisticsMapper;
    @Autowired
    AdminMallMapper adminMallMapper;
    @Override
    public void statOrder() {
        //给日期排序
        TreeSet<Date> ordersSet = new TreeSet<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });

        List<Order> orders = adminMallMapper.selectOrders(new Order());
        Date payTime = orders.get(0).getPayTime();
        ordersSet.add(payTime);

        for (Order order : orders) {
            Date payTime1 = order.getPayTime();
            if(!ordersSet.contains(payTime1)){
                ordersSet.add(payTime1);
            }
        }

        for (Date date : ordersSet) {
            System.out.println(date);
        }
    }
}
