package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.Order;
import com.cskaoyan.mall.mallStart.bean.StatOrder;
import com.cskaoyan.mall.mallStart.bean.StatOrderBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminStatisticsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminStatisticsSeviceImpl implements AdminStatisticsSevice{
    @Autowired
    AdminStatisticsMapper adminStatisticsMapper;
    @Autowired
    AdminMallMapper adminMallMapper;
    @Autowired
    AdminUserMapper adminUserMapper;
    @Override
    public StatOrderBean statOrder() {
        //给日期排序
        TreeSet<Date> ordersSet = new TreeSet<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });

        List<Order> orders = adminMallMapper.selectOrders(new Order());

        for (Order order : orders) {
            Date payTime = order.getPayTime();
            if(payTime!=null) {
                ordersSet.add(payTime);
                break;
            }
        }

        for (Order order : orders) {
            Date payTime1 = order.getPayTime();
            if(payTime1 != null && !ordersSet.contains(payTime1) ){
                ordersSet.add(payTime1);
            }
        }
        //成交金额
        List<StatOrder> statOrderList = new ArrayList<>();
        for (Date date : ordersSet) {
            StatOrder statOrder = new StatOrder();
            double v = adminStatisticsMapper.selectSumOrderPriceByPaytime(date);
            int i = adminStatisticsMapper.selectSumUserByPaytime(date);
            statOrder.setAmount(v);
            statOrder.setCustomers(i);
            statOrder.setDay(date);
            statOrder.setPcr(v/i);
            statOrder.setOrders(adminStatisticsMapper.selectSumOrderByPaytime(date));
            statOrderList.add(statOrder);
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("day");
        stringList.add("orders");
        stringList.add("customers");
        stringList.add("amount");
        stringList.add("pcr");

        StatOrderBean statOrderBean = new StatOrderBean();
        statOrderBean.setColumns(stringList);
        statOrderBean.setRows(statOrderList);
        return statOrderBean;
    }

    @Override
    public StatOrderBean statUser() {
        List<User> users = adminStatisticsMapper.selectUserAllGroupByAddTime();
        StatOrderBean statOrderBean = new StatOrderBean();
        List<String> stringList = new ArrayList<>();
        stringList.add("day");
        stringList.add("users");
        statOrderBean.setColumns(stringList);

        List<StatOrder> statOrderList = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        for (User user : users) {
            int users1 = adminStatisticsMapper.selectSumUserByAddTime(user.getAddTime());
            StatOrder statOrder = new StatOrder();
            count1 = users1-count;
            count = users1;
            statOrder.setUsers(count1);
            statOrder.setDay(user.getAddTime());
            statOrderList.add(statOrder);
        }
        statOrderBean.setRows(statOrderList);
        return statOrderBean;
    }

    @Override
    public StatOrderBean staOrder() {
        TreeSet<Date> ordersSet = new TreeSet<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });

        List<Order> orders = adminMallMapper.selectOrders(new Order());


        for (Order order : orders) {
            Date payTime = order.getPayTime();
            if(payTime!=null) {
                ordersSet.add(payTime);
                break;
            }
        }

        for (Order order : orders) {
            Date payTime1 = order.getPayTime();
            if(payTime1!=null&&!ordersSet.contains(payTime1)){
                ordersSet.add(payTime1);
            }
        }

        List<StatOrder> statOrderList = new ArrayList<>();
        for (Date date : ordersSet) {
            StatOrder statOrder = new StatOrder();
            int count =adminStatisticsMapper.selectSumOrderByPaytime(date);
            //商品总数
            List<Integer> orderList = adminStatisticsMapper.selectOrderIdByPayTime(date);
            int goodnum = 0;
            for (Integer order : orderList) {
                goodnum += adminStatisticsMapper.selectSumOrderById(order);
            }
            statOrder.setOrders(count);
            statOrder.setProducts(goodnum);
            statOrder.setDay(date);
            statOrder.setAmount(adminStatisticsMapper.selectSumOrderPriceByPaytime(date));
            statOrder.setOrders(adminStatisticsMapper.selectSumOrderByPaytime(date));
            statOrderList.add(statOrder);
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("day");
        stringList.add("orders");
        stringList.add("products");
        stringList.add("amount");

        StatOrderBean statOrderBean = new StatOrderBean();
        statOrderBean.setColumns(stringList);
        statOrderBean.setRows(statOrderList);
        return statOrderBean;
    }
}
