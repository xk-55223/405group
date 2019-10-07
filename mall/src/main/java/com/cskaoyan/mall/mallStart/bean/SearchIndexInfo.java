package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class SearchIndexInfo {
    Keyword defaultKeyword;
    List<Keyword> historyKeywordList;
    List<Keyword> hotKeywordList;


    public Keyword getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(Keyword defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<Keyword> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<Keyword> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<Keyword> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<Keyword> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }
}
