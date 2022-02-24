package base.sort;

import org.junit.Test;
import utils.AlgorithmUtil;

import java.util.Arrays;

/**
 * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，
 * 将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 *
 * 选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
 * @param <T>
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {

//    int[] ints = AlgorithmUtil.randomArray(100000, 10000, 0);

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void sortByRoy(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int swap = nums[j];
                    nums[j] = nums[i];
                    nums[i] = swap;
                }
            }
        }
    }


    @Test
    public void demo() {
        System.out.println(Arrays.toString(array));
        Selection<Integer> selection = new Selection<Integer>();
        selection.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void demo2() {
        System.out.println(Arrays.toString(array));
        Integer[] intArr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        new Selection<Integer>().sortByRoy(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}