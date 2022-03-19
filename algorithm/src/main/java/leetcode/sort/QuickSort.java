package leetcode.sort;

import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 快速排序使用分治法
 * 初始时 start为0， end为数组长度-1
 * 标记一个分区点，同时将数组以分区点作为大小分区，小的放在左边，大的在右
 * 之后不断递归 start~partition-1  和 partition+1 ~ end
 *
 * @author Fang
 * @date 2022-03-19 22:36
 */
public class QuickSort {
    public static void sort(int[] array, int start, int end) {
        int partition = getPartition(array, start, end);
        if (partition > start) {
            sort(array, start, partition-1);
        }
        if (partition < end) {
            sort(array, partition+1, end);
        }
    }

    private static int getPartition(int[] array, int start, int end) {
        if (start == end) {
            return start;
        }
        // 找个区间内的基准数
        int pivot = (start + end) / 2;
        // 交换基准数
        swap(array, end, pivot);
        int zoneIndex = start - 1;
        int i = start;
        while (i <= end) {
            // 当前元素小于基准数
            if (array[i] <= array[end]){
                // 分区指针累加
                zoneIndex++;
                // 当前元素在分区指针右边，则交换当前元素和分区指针元素
                if (i > zoneIndex) {
                    swap(array, i, zoneIndex);
                }
            }
            i++;
        }
        return zoneIndex;
    }

    public static void main(String[] args) {
//        int[] array = AlgorithmUtil.randomArray(8, 100, 1);
        int[] array = {88, 48, 5, 1, 90, 2, 50, 48};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
