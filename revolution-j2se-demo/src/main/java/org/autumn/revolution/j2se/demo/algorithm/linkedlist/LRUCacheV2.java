package org.autumn.revolution.j2se.demo.algorithm.linkedlist;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/10
 */
public class LRUCacheV2 {


    class Node{
       String key, val;
       Node pre, next;
       Node(String key, String val){
           this.key = key;
           this.val = val;
           pre = this;
           next = this;
       }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

    }

    private int capacity;
    /**
     * 引入虚拟节点，dummy的next指向head，pre指向tail
     */
    private Node dummy;
    private Map<String, Node> cache;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Node getDummy() {
        return dummy;
    }

    public void setDummy(Node dummy) {
        this.dummy = dummy;
    }

    public Map<String, Node> getCache() {
        return cache;
    }

    public void setCache(Map<String, Node> cache) {
        this.cache = cache;
    }

    public LRUCacheV2(int capacity){
        this.capacity = capacity;
        dummy = new Node("dummy", "");
        cache = new ConcurrentHashMap<>(capacity);
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    public String get(String key){
        //节点移动到链表尾部
        Node node = cache.get(key);
        if(node == null){
            return null;
        }
        remove(node);
        add(node);
        return node.val;
    }

    /**
     * 缓存中放入元素
     * @param key
     * @param val
     */
    public void put(String key, String val){
        // 如果包含key
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            cache.remove(key);
            remove(node);
            node = new Node(key, val);
            cache.put(key, node);
            add(node);
        }else{
            Node node = new Node(key, val);
            // 添加到链表尾部
            add(node);
            cache.put(key, node);
            // 判断容量
            if(cache.size() > capacity){
                cache.remove(dummy.next.key);
                // 头部节点移除
                remove(dummy.next);
            }
        }
    }

    /**
     * 添加到链表尾部
     * @param node
     */
    public void add(Node node){
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }

    /**
     * 从链表中删除节点
     * @param node
     */
    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {

        LRUCacheV2 lruCacheV2 = new LRUCacheV2(3);
        lruCacheV2.put("k1", "v1");
        lruCacheV2.put("k2", "v2");
        lruCacheV2.put("k3", "v3");
        System.out.println(JSON.toJSONString(lruCacheV2));
        lruCacheV2.put("k4", "v4");
        System.out.println(JSON.toJSONString(lruCacheV2));
        lruCacheV2.get("k2");
        System.out.println(JSON.toJSONString(lruCacheV2));

    }


}
