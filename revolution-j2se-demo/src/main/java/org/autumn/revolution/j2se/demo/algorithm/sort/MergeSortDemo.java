package org.autumn.revolution.j2se.demo.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/3/2
 */
public class MergeSortDemo {

    public static void mergeSort(int[] src){
        mergeSort(src, 0, src.length - 1);
    }

    public static void mergeSort(int[] src, int left, int right){
        // 递归终止条件
        if(left >= right){
            return;
        }
        // 取p到r中间位置
        int mid = (left + right) / 2;
        mergeSort(src, left, mid);
        mergeSort(src, mid + 1, right);
        merge(src, left, mid, right);
    }

    public static void merge(int[] src, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right){
            tmp[k++] = src[i] < src[j] ? src[i++] : src[j++];
        }
        while (i <= mid){
            tmp[k++] = src[i++];
        }
        while (j <= right){
            tmp[k++] = src[j++];
        }
        // 将排好序的临时数组拷贝至原数组相应位置
        int index = 0;
        while (index < tmp.length){
            src[left++] = tmp[index++];
        }
    }



    public static void main(String[] args) {

        int[] src = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(src);
        System.out.println(JSON.toJSONString(src));
    }
}
