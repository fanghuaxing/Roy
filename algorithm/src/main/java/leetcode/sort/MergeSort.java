package leetcode.sort;

import org.junit.Test;
import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 将一个大数组分成两个小数组去求解。
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 */
public class MergeSort{
    protected int[] aux;

    // 合并子数组
    protected void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            aux[k] = nums[k]; // 将数据复制到辅助数组
        }
        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i] < (aux[j])) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    private void sort(int[] nums, int l, int h) {
        if (aux == null) {
            aux = new int[h + 1];
        }
        if (h <= l) { return; }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    @Test
    public void demo() {
        int[] intArrays = AlgorithmUtil.randomArray(8, 100, 1);
        System.out.println(Arrays.toString(intArrays));
        new MergeSort().sort(intArrays,0,intArrays.length-1);
        System.out.println(Arrays.toString(intArrays));
    }
}