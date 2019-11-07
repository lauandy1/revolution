package org.autumn.revolution.j2se.demo.algorithm.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * created by yangzhichao on 2019/11/2
 */
public class Q3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char [] cs = s.toCharArray();
        // 用于记录值和位置下标
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put((int)cs[0], 0);
        for(int i = 0, j = i + 1; i < cs.length && j < cs.length; ){
            int v = cs[j];
            // 如果包含v2，说明有重复，左指针前进, 右指针也前进
            if(map.containsKey(v)){
                // 比较max和当前map的size
                if(map.size() > max){
                    max = map.size();
                }
                // 取出重复值对应的下标位置，i要前进到此位置前面一位
                i = map.get(v) + 1;
                // 判断边界
                if(i == cs.length - 1){
                    break;
                }
                j = i + 1;
                // 重复之后要清空map
                map.clear();
                // 下标重定位后，map从此位置重新初始化赋值
                map.put((int)cs[i], i);
                map.put((int)cs[j], j);
                j++;
            }else{ // 如果不包含，说明没重复，右指针前进
                map.put(v, j);
                j++;
            }
        }
        return max > map.size() ? max : map.size();
    }

    public static void main(String[] args) {
//        char c = 'a';
//        System.out.println((int)c);
//        char c1 = 'A';
//        System.out.println((int)c1);

        //String str = "afabcbe";
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
