package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

/**
 * created by yangzhichao on 2019/11/10
 */
public class Q414 {

    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        int max = 0;
        int second = 0;
        int third = 0;
        boolean flag = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                if(third < second){
                    third = second;
                    flag = false;
                }
                if(second < max){
                    second = max;
                }
                max = nums[i];
            }else if(nums[i] > second){
                if(nums[i] < max){
                    if(third < second){
                        third = second;
                        flag = false;
                    }
                    second = nums[i];
                }
            }else if(nums[i] > third){
                if(nums[i] < second){
                    third = nums[i];
                    flag = false;
                }
            }
        }
        if(flag){
            return max;
        }
        return third;
    }

    public static int thirdMax2(int[] nums){
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for(long num : nums){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }else if(num > second && num < first){
                third = second;
                second = num;
            }else if(num > third && num < second){
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int)first : (int)third;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(thirdMax2(nums));

    }
}
