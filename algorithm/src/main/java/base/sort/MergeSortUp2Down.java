package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 将一个大数组分成两个小数组去求解。
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 * @param <T>
 */
public class MergeSortUp2Down<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    @Test
    public void demo() {
        System.out.println(Arrays.toString(intArrays));
        new MergeSortUp2Down<Integer>().sort(intArrays);
        System.out.println(Arrays.toString(intArrays));
    }
}