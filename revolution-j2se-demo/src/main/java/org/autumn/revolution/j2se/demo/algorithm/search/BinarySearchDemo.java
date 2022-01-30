package org.autumn.revolution.j2se.demo.algorithm.search;

public class BinarySearchDemo {

    /**
     * loop
     * @param src
     * @param target
     * @return
     */
    public static int binarySearch(int[] src, int target){
        if(src == null || src.length == 0){
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(src[mid] == target){
                return mid;
            }else if(src[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * recursion
     * @param src
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] src, int target, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if(src[mid] == target){
            return mid;
        }else if(src[mid] > target){
            return binarySearch(src, target, low, mid - 1);
        }else {
            return binarySearch(src, target, mid + 1, high);
        }
    }

    /**
     * 查找第一个等于目标值的位置
     * @param src
     * @param target
     * @return
     */
    public static int searchFirst(int[] src, int target){
        int low = 0;
        int high = src.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(src[mid] > target){
                high = mid - 1;
            }else if(src[mid] < target){
                low = mid + 1;
            }else {
                if(mid == 0 || src[mid - 1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于目标值的位置
     * @param src
     * @param target
     * @return
     */
    public static int searchLast(int[] src, int target){
        int low = 0;
        int high = src.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(src[mid] > target){
                high = mid - 1;
            }else if(src[mid] < target){
                low = mid + 1;
            }else {
                if(mid == src.length - 1 || src[mid + 1] != target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] src = new int[]{1, 2, 3, 5, 6, 6, 6, 7, 8, 12, 13, 14};
        System.out.printf("loop-target value pos is : %d\n", binarySearch(src, 6));
        System.out.printf("recursion-target value pos is : %d\n", binarySearch(src, 6, 0, src.length - 1));
        System.out.printf("first target value pos is : %d\n", searchFirst(src, 6));
        System.out.printf("last target value pos is : %d\n", searchLast(src, 6));

    }
}
