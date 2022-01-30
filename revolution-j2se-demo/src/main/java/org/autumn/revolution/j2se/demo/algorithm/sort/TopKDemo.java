package org.autumn.revolution.j2se.demo.algorithm.sort;

public class TopKDemo {

    public static int findTopK(int[] src, int k){
        int topK = find(src, k, 0, src.length - 1);
        return src[topK];
    }

    public static int find(int[] src, int k, int low, int high){
        int pivotIndex = quickSort(src, low, high);
        if(pivotIndex + 1 == k){
            return pivotIndex;
        }else if(pivotIndex + 1 < k){
            find(src, k, pivotIndex + 1, high);
        }else {
            find(src, k, low, pivotIndex);
        }
        return pivotIndex;
    }

    public static int quickSort(int[] src, int low, int high){
        int pivotIndex = low;
        int pivot = src[low];
        while (low < high){
            while (low < high && src[high] >= pivot){
                high--;
            }
            while (low < high && src[low] <= pivot){
                low++;
            }
            if(low < high){
                swap(src, low, high);
            }
        }
        src[pivotIndex] = src[low];
        src[low] = pivot;
        return low;
    }

    public static void swap(int[] src, int i, int j){
        int tmp  = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    public static void main(String[] args) {
        int[] src = new int[]{8,10,2,3,6,1,5};
        System.out.println(findTopK(src, 2));
    }
}
