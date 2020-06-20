package com.haogenmin.demo.model;

import java.io.Serializable;

/**
 * @author ：HaoGenmin
 * @Title :DataSourceInfo
 * @date ：Created in 2020/6/19 14:50
 * @description：
 */
public class DataSourceInfo implements Serializable {
    private Integer id;
    private String datasourceKey;
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatasourceKey() {
        return datasourceKey;
    }

    public void setDatasourceKey(String datasourceKey) {
        this.datasourceKey = datasourceKey;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSourceInfo{" +
                "id=" + id +
                ", datasourceKey='" + datasourceKey + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
