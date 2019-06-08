package org.autumn.revolution.j2se.demo.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * created by yangzhichao on 2017/12/26
 */
public class Q001 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = new int[] {2, 6, 3, 9, 23};

        System.out.println(Arrays.toString(twoSum(nums, 9)));


    }
}
