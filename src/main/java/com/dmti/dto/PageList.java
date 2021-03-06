package com.dmti.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PageList {
    List<Map<String,Object>> rows = new ArrayList<>();
    Integer total;
    Integer totalNotFiltered;

    public PageList() { }

    public PageList(List<Map<String, Object>> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
