package utils;

public class AlgorithmUtil {
    //  生成随机数组，可指定长度，可指定数据范围
    public static int[] randomArray(int arrLength, int max, int min) {
        //  创建一个数组对象 指定长度为arrLength
        int[] arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            //  循环赋值
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }

    public static Integer[] randomIntegerArray(int arrLength, int max, int min) {
        //  创建一个数组对象 指定长度为arrLength
        Integer[] arr = new Integer[arrLength];
        for (int i = 0; i < arr.length; i++) {
            //  循环赋值
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }
}