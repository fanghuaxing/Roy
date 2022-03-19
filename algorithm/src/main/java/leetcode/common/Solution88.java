package leetcode.common;

import java.util.Arrays;

public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[m + n];
        if (m == 0) {
            array = nums2;
            System.arraycopy(array, 0, nums1, 0, nums1.length);
            return;
        }
        if (n == 0) {
            array = nums1;
            System.arraycopy(array, 0, nums1, 0, nums1.length);
            return;
        }
        int index_1 = 0, index_2 = 0;
        for (int i = 0; i < array.length; i++) {
            //
            if (index_1 == m){
                array[i] = nums2[index_2];
                index_2++;
            } else if (index_2 == n) {
                array[i] = nums1[index_1];
                index_1++;
            } else if (nums1[index_1] <= nums2[index_2]){
                array[i] = nums1[index_1];
                index_1++;
            }  else {
                array[i] = nums2[index_2];
                index_2++;
            }
        }
        System.arraycopy(array, 0, nums1, 0, array.length);
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        merge(ints,3, new int[]{2, 5, 6} ,3);
        System.out.println(Arrays.toString(ints));

    }

}