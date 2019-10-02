package com.cskaoyan.mall.mallStart.tool;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class BeansManager<T> {
    public ListBean<T> toListBean(List<T> beans) {
        PageInfo<T> pageInfo = new PageInfo<>(beans);
        long total = pageInfo.getTotal();
        ListBean<T> listBean = new ListBean<>();
        listBean.setItems(beans);
        listBean.setTotal(total);
        return listBean;
    }
}
