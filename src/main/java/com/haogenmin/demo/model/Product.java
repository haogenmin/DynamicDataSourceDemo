package com.haogenmin.demo.model;

import java.io.Serializable;

/**
 * @author ：HaoGenmin
 * @Title :Product
 * @date ：Created in 2020/6/18 13:42
 * @description：
 */
public class Product implements Serializable {
    private Integer pid;
    private String productName;
    private String dbSource;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productName='" + productName + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
