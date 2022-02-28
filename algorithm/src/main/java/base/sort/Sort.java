package base.sort;

import utils.AlgorithmUtil;

/**
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 * 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好。
 * 排序算法的成本模型是比较和交换的次数。
 * @param <T>
 */
public abstract class Sort<T extends Comparable<T>> {

    int[] array = AlgorithmUtil.randomArray(10, 10, 0);

    int[] bigArray = AlgorithmUtil.randomArray(10000, 1000, 0);

    Integer[] intArrays = AlgorithmUtil.randomIntegerArray(10, 10, 0);

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}