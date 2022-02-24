package base.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素,右子数组大于等于切分元素，
 * 将这两个子数组排序也就将整个数组排序了。
 * <p>
 * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，  再从数组的右端向左扫描找到第一个小于它的元素，
 * 交换这两个元素。不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
 * 当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        this.sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        System.out.println("切分元素: " + l + "-" + h + " partition:" + j);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private int partition(T[] nums, int startIndex, int endIndex) {
        int i = startIndex, j = endIndex + 1;
        T v = nums[startIndex];
        while (true) {
            while (less(nums[++i], v) && i != endIndex) ;
            while (less(v, nums[--j]) && j != startIndex) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            System.out.println(i + "<->" + j + " " + Arrays.toString(nums));
        }
        swap(nums, startIndex, j);
        System.out.println(startIndex + "<->" + j + " " + Arrays.toString(nums));
        return j;
    }


    @Test
    public void demo() {
        System.out.println(Arrays.toString(array));
        System.out.println("Arrays.toString(array)");
        Integer[] intArr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        new QuickSort<Integer>().sort(intArr);
        System.out.println(Arrays.toString(intArr));
        System.out.println("Arrays.toString(intArr)");
    }
}