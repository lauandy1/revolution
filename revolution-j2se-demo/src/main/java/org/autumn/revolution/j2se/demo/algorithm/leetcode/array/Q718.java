package org.autumn.revolution.j2se.demo.algorithm.leetcode.array;

/**
 * created by yangzhichao on 2019/11/17
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Q718 {

    /**
     * 思路：
     * 穷举法
     * 从长度为1的子串开始比，一直比较到长度为min(len(A),len(B))
     * 以A为基准开始遍历，当长度为1的子串找到时停止，开始遍历长度为2的子串，依次类推
     * 当长度为n的子串找不到时停止遍历，公共最长即为n-1
     *
     * 思路2：
     * 动态规划，状态方程dp[i][j] = dp[i-1][j-1] + 1
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] temp = new int[A.length][B.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if (i == 0 || j == 0) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = temp[i - 1][j - 1] + 1;
                    }
                }
                res = Math.max(temp[i][j], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        System.out.println(findLength(A, B));


    }
}
