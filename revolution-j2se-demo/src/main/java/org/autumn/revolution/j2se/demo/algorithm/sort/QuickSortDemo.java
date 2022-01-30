package org.autumn.revolution.j2se.demo.algorithm.sort;

import com.alibaba.fastjson.JSON;

public class QuickSortDemo {

    public static void quickSort(int[] src, int left, int right){
        if(left >= right){
            return;
        }
        // 获取分区点
        int pivot = partition(src, left, right);
        quickSort(src, left, pivot - 1);
        quickSort(src, pivot + 1, right);
    }

    /**
     * 最左边元素作为基准元素
     * @param src
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] src, int left, int right){
        int pivotPos = left;
        int pivot = src[pivotPos];
        while (left < right){
            while (left < right && src[right] > pivot){
                right--;
            }
            while (left < right && src[left] <= pivot){
                left++;
            }
            if(left < right){
                int tmp = src[left];
                src[left] = src[right];
                src[right] = tmp;
            }
        }
        src[pivotPos] = src[left];
        src[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] src = new int[]{8,10,2,3,6,1,5};
        quickSort(src, 0, src.length - 1);
        System.out.println(JSON.toJSONString(src));

    }
}
