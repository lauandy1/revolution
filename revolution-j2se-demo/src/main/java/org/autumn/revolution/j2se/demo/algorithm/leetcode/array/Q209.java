package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * created by yangzhichao on 2019/11/18
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 */
public class Q209 {

    /**
     * 思路：
     * 1.穷举
     * i从0开始遍历，相加到>=s时，比较min和j-i;
     * i++
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int min = nums.length;
        boolean isSet = false;
        for(int i = 0; i < nums.length; i++){
            int base  = nums[i];
            if(base >= s){
                min = 1;
                return min;
            }
            for(int j = i + 1; j < nums.length; j++){
                if((base += nums[j]) >= s){
                    min = Math.min(min, j - i + 1);
                    isSet = true;
                    break;
                }
            }
        }
        return isSet ? min : 0;
    }

    /**
     * 思路：
     * 2.穷举的话，多次遍历过程存在很多重复判断，性能太差
     * 可以记录之前遍历过程中判断过的结论
     * 1）外层遍历终止的条件，上一次遍历如果没有找到>s的范围，那么没必要进行后续的遍历了
     * 2）一次遍历，如果找到范围就终止，那么本次遍历存储终止范围就好了
     * 3)
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int min = nums.length;
        boolean isSet = false;
        Map<Integer, Integer[]> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && !map.containsKey(i - 1)){
                return isSet ? min : 0;
            }
            int base  = nums[i];
            if(base >= s){
                min = 1;
                return min;
            }
            for(int j = i + 1; j < nums.length; j++){
                if((base += nums[j]) >= s){
                    min = Math.min(min, j - i + 1);
                    isSet = true;
                    map.put(i, new Integer[]{i, j});
                    break;
                }
            }
        }
        return isSet ? min : 0;
    }



    public static void main(String[] args) {

        int s = 4;
        int[] nums = new int[] {1,4,4};
        System.out.println(minSubArrayLen(s, nums));

    }


}
