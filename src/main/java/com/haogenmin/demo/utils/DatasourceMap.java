package com.haogenmin.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author ：HaoGenmin
 * @Title :DatasourceMap
 * @date ：Created in 2020/9/16 8:32
 * @description：
 */
@Component
public class DatasourceMap implements Map {
    private static final String DATASOURCE_KEY = "dataSource";

    @Autowired
    RedisClient redisClient;

    @Override
    public int size() {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        return key_value.size();
    }

    @Override
    public boolean isEmpty() {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        return key_value.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return redisClient.hHasKey(DATASOURCE_KEY, (String) key);
    }

    @Override
    public boolean containsValue(Object value) {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        return key_value.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return redisClient.hget(DATASOURCE_KEY, (String) key);
    }

    @Override
    public Object put(Object key, Object value) {
        return redisClient.hset(DATASOURCE_KEY, (String) key,value);
    }

    @Override
    public Object remove(Object key) {
        redisClient.hdel(DATASOURCE_KEY,key);
        return null;
    }

    @Override
    public void putAll(Map m) {
        redisClient.hmset(DATASOURCE_KEY,m);
    }

    @Override
    public void clear() {
        redisClient.del(DATASOURCE_KEY);
    }

    @Override
    public Set keySet() {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        return key_value.keySet();
    }

    @Override
    public Collection values() {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        return key_value.values();
    }

    @Override
    public Set<Entry> entrySet() {
        Map<Object, Object> key_value = redisClient.hmget(DATASOURCE_KEY);
        Set set = key_value.entrySet();
        return set;
    }
}
