package org.autumn.revolution.j2se.demo.algorithm.leetcode.str;

import java.util.Arrays;

/**
 * created by yangzhichao on 2019/11/7
 */
public class Q5 {

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        char[] cs = s.toCharArray();
        int[] maxPos = new int[2];
        for(int i = 0; i < cs.length; i++){
            int[] scope = findOne(i, cs);
            if(scope[1] - scope[0] > maxPos[1] - maxPos[0]){
                maxPos = scope;
            }
        }
        if(maxPos[1] >= maxPos[0]){
            char[] maxCs = Arrays.copyOfRange(cs, maxPos[0], maxPos[1] + 1);
            return new String(maxCs);
        }
        return "";
    }

    /**
     * 从0位置开始迭代，
     * 确定本次迭代的左右边界，
     * 右边界可以作为下次迭代的起始位置；
     * 本次迭代要确定中心点，中心点可能是1位也可能是连续相同的多位，
     * 确定中心点后开始向左右两个方向寻找相同字符，遇到超过边界或者不同就结束，
     * 记录本次迭代确定的左右边界
     * @param pos
     * @param cs
     * @return
     */
    public static int[] findOne(int pos, char[] cs){
        int[] scope = new int[2];
        // 1.确定中心点
        // 设置左右边界
        int l = pos;
        int r = pos;
        // 遍历确定中心点左边界
        while(l >= 0){
            if (l - 1 >= 0 && cs[l-1] == cs[l]) {
                l--;
            }else{
                // 不满足就立刻结束迭代
                break;
            }
        }
        // 遍历确定中心点右边界
        while(r < cs.length) {
            if (r + 1 < cs.length && cs[r] == cs[r+1]) {
                r++;
            }else{
                // 不满足就立刻结束迭代
                break;
            }
        }
        // 中心点为l到r间的字符
        // 2.开始向左右迭代
        // while指定边界条件，不满足就不会迭代
        while (l >= 0 && r < cs.length){
            if(l - 1 >= 0 && r + 1 < cs.length && cs[l-1] == cs[r+1]){
                l--;
                r++;
            }else{
                break;
            }
        }
        scope[0] = l;
        scope[1] = r;
        return scope;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("aab"));
    }


}

