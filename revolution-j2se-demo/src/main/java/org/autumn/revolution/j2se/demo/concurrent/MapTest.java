package org.autumn.revolution.j2se.demo.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/11/25
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put(null,"empty");
    }
}
