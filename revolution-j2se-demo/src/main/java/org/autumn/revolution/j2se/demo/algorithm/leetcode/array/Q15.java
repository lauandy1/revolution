package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzhichao on 19/10/29.
 */
public class Q15 {


    /**
     * 求出数组内三元组的和为0的组合，要求组合数字不重复
     * 基本思路：1.首先遍历数组把数组值和位置关系保存到map
     * 2.再次遍历数组，穷举两两组合，判断之和到map里找相加为0对应的值，如果找到存储到最终结果集，
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        return null;
    }


    public void sort(int[] nums) {

    }

    /**
     * 1.先排序
     * 2.三指针遍历i,j,k
     * 如果i+j<k，j++；如果i+j>k，k--；如果相等则符合条件的一组；当j和k走到中间位置时，内层遍历结束。
     * 外层遍历继续，i++，继续内层遍历；外层遍历当i=len-2时结束
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {


        return null;
    }
}
