package leetcode.sort;

import base.sort.Sort;
import org.junit.Test;
import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 堆排序
 * 堆是是一颗完全二叉树，
 * 并且中某个节点的值总是大于等于或小于等于其子节点的值，
 * <p>
 * 堆可以用数组来表示，这是因为堆是完全二叉树， 而完全二叉树很容易就存储在数组中。
 * 位置 k 的节点的父节点位置为 k/2，而它的两个子节点的位置分别为 2k 和 2k+1。
 * 这里不使用数组索引为 0 的位置，是为了更清晰地描述节点的位置关系。
 *
 *
 * @author Fang
 * @date 2022-03-20 0:55
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

    @Test
    public void demo() {
        Integer[] array = AlgorithmUtil.randomIntegerArray(10, 100, 1);
        System.out.println(Arrays.toString(array));
        new HeapSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}