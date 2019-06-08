package org.autumn.revolution.j2se.demo.algorithm.leetcode;

import java.util.*;

/**
 * created by yangzhichao on 2018/1/16
 */
public class Q002 {

    public static String findLongestSub(String source){
        char[] cs = source.toCharArray();
        int lengthMax = 0;
        int posMax = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0, j = 0; j < cs.length; j++){
            char c = cs[j];
            // 如果已经存在，证明之前添加过，需要重置
            if(map.containsKey(c)){
                // 取出之前的位置
                int pos = map.get(c);
                // 计算本次覆盖的子串长度
                int length = j - i;
                // 重新赋值lengthMax
                if(length > lengthMax){
                    lengthMax = length;
                    posMax = i;
                }
                // 重置i的位置
                i = pos + 1;
                // 清空map

            }else{
                // 存储该字符及其数组下标
                map.put(c, j);
            }
        }
        return source.substring(posMax, posMax + lengthMax);
    }

    public static void main(String[] args) {
        System.out.println(findLongestSub("abcbdefh"));
    }
}
