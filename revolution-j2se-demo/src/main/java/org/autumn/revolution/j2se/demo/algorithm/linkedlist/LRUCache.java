package org.autumn.revolution.j2se.demo.algorithm.linkedlist;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/10
 */
public class LRUCache<K, V> {

    private Map<K, V> cache;

    public Map<K, V> getCache() {
        return cache;
    }

    public void setCache(Map<K, V> cache) {
        this.cache = cache;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int capacity;

    public LRUCache(int capacity){
        cache = new LinkedHashMap<K, V>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public V get(K key){
        return cache.get(key);
    }

    public void put(K key, V val){
        cache.put(key, val);
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(3);
        lruCache.put("k1", "v1");
        lruCache.put("k2", "v2");
        lruCache.put("k3", "v3");
        System.out.println(JSON.toJSONString(lruCache));
        lruCache.put("k4", "v4");
        System.out.println(JSON.toJSONString(lruCache));
        lruCache.get("k3");
        System.out.println(JSON.toJSONString(lruCache));
        lruCache.put("k1", "v1");
        System.out.println(JSON.toJSONString(lruCache));

    }
}
