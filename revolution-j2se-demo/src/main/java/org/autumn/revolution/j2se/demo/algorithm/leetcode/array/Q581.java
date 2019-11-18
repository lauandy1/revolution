package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

/**
 * created by yangzhichao on 2019/11/16
 */
public class Q581 {

    /**
     * 基本思路：
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j && nums[i] <= nums[j]){
            if(nums[i] <= nums[i + 1]){
                i++;
            }else if(nums[j] >= nums[j - 1]){
                j--;
            }else {
                break;
            }
        }
        return j > i ? j - i + 1 : 0;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int r = -1, l = nums.length;
        //从左往右遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max)
                max = nums[i];
            else
                r = i;
        }
        //从右往左遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min)
                min = nums[i];
            else
                l = i;
        }
        return r > l ? r - l + 1 : 0;
    }

//    public int findUnsortedSubarray3(int[] nums) {
//        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        int r = -1, l = nums.length;
//        //从左往右遍历
//        for (int i = 0, j = nums.length - 1; i < nums.length || j >= 0; i++, j--) {
//            if (nums[i] >= max){
//                max = nums[i];
//            } else{
//                r = i;
//            }
//            if (nums[i] <= min){
//                min = nums[i];
//            } else {
//                l = i;
//            }
//        }
//        return r > l ? r - l + 1 : 0;
//    }


    public static void main(String[] args) {
        //int[] nums = new int[]{2,6,4,8,10,9,15};
        //int[] nums = new int[]{1,3,2,2,2};
        int[] nums = new int[]{2,3,3,2,4};
        System.out.println(findUnsortedSubarray2(nums));
    }
}
