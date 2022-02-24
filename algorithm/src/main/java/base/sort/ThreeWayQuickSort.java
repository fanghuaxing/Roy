package base.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 *
 * @param <T>
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    public void sort(T[] nums) {
        this.sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int begin, int end) {
        if (end <= begin) {
            return;
        }
        // 其中lt指针使得元素（arr[0]-arr[lt-1]）的值均小于切分元素；
        // i指针使得元素（arr[lt]-arr[i-1]）的值均等于切分元素
        // gt指针使得元素（arr[gt+1]-arr[N-1]）的值均大于切分元素；
        int lt = begin, i = begin + 1, gt = end;
        T v = nums[begin];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                System.out.println(lt + "<->" + i);
                swap(nums, lt++, i++);
                System.out.println(  Arrays.toString(nums));
            } else if (cmp > 0) {
                System.out.println(i + "<->" + gt);
                swap(nums, i, gt--);
                System.out.println(  Arrays.toString(nums));
            } else {
                i++;
            }
        }
        sort(nums, begin, lt - 1);
        sort(nums, gt + 1, end);
    }

    @Test
    public void demo() {
        System.out.println(Arrays.toString(array));
        System.out.println("Arrays.toString(array)");
        Integer[] intArr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        new ThreeWayQuickSort<Integer>().sort(intArr);
        System.out.println(Arrays.toString(intArr));
        System.out.println("Arrays.toString(intArr)");
    }
}