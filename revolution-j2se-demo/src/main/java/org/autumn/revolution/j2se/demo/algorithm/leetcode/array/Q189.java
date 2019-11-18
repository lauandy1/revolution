package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

/**
 * created by yangzhichao on 2019/11/9
 */
public class Q189 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 做k次移动
        for(int i = 0; i < k; i++){
            for(int j = nums.length - 1; j > 0; j--){
                int a = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = a;
            }
        }
    }

    /**
     * 优化版本
     * 计算k和nums长度的差值，如果k小就正向移动，如果k大就反向移动
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if(k >= nums.length - k){
            // 做nums.length - k次反向移动
            for(int i = 0; i < nums.length - k; i++){
                for(int j = 0; j < nums.length - 1; j++){
                    int a = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = a;
                }
            }
        }else{
            // 做k次正向移动
            for(int i = 0; i < k; i++){
                for(int j = nums.length - 1; j > 0; j--){
                    int a = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = a;
                }
            }
        }
    }

    /**
     * 最优版本，一次遍历，直接计算出交换次数和位置
     * [1,2,3,4,5,6,7]为例
     * k=1，移动次数6次，len - k
     * [7,1,2,3,4,5,6]
     * k=2, 移动次数5次，len - k
     * [6,7,1,2,3,4,5]
     * k=3, 移动次数4次，
     * [5,6,7,1,2,3,4]
     * k=4, 移动4个数
     * [4,5,6,7,1,2,3]
     * k=5, 移动5个数
     * [3,4,5,6,7,1,2]
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        if(k >= nums.length - k){
            // 移动k次，记录len - k个位置

        }else{
            // 移动len - k次，记录k个位置

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        rotate2(nums, 3);
        for(int a : nums){
            System.out.println(a);
        }

    }
}
