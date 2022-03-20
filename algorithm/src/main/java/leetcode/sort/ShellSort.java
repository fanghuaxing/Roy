package leetcode.sort;

import base.sort.Sort;
import org.junit.Test;
import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 哈希排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 * @param <T>
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int len = nums.length;
        int h = 1;
        while (h <  len / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    @Test
    public void demo() {
        Integer[] array = AlgorithmUtil.randomIntegerArray(8, 100, 1);
        System.out.println("begin:" + Arrays.toString(array));
        new ShellSort().sort(array);
        System.out.println("end" + Arrays.toString(array));
    }
}
