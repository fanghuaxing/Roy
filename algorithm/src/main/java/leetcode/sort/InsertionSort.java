package leetcode.sort;

import base.sort.Sort;
import org.junit.Test;
import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
 * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
 * 插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
 *
 */
public class InsertionSort {

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 &&  nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


    @Test
    public void demo() {
        int[] array = AlgorithmUtil.randomArray(8, 100, 1);
        System.out.println("begin:" + Arrays.toString(array));
        new InsertionSort().sort(array);
        System.out.println("end" + Arrays.toString(array));
    }
}