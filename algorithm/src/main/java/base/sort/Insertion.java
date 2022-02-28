package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
 * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
 * 插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
 *
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public void sortByRoy(T[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                    System.out.println(Arrays.toString(nums));
                }
            }
        }
    }

    @Test
    public void demo() {
        System.out.println(Arrays.toString(intArrays));
        new Insertion<Integer>().sort(intArrays);
        System.out.println(Arrays.toString(intArrays));
    }
}