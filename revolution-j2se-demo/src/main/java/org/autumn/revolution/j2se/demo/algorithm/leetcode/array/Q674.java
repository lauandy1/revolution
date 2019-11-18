package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

/**
 * created by yangzhichao on 2019/11/15
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 输入: [1,3,5,4,7]，输出: 3，解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 */
public class Q674 {

    /**
     * 思路梳理：
     * 1.定义一个变量记录长度
     * 2.从头到尾遍历，遇到后面大于前面就+1，停止时和长度比较是否替换
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxLength = 1;
        int length = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] > nums[i]){
                length++;
            }else{
                maxLength = maxLength > length ? maxLength : length;
                length = 1;
                continue;
            }
        }
        return maxLength > length ? maxLength : length;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }

}
