package sword_offer.to25;

public class Solution_03 {
    //在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
    // 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    public static int duplicate (int[] numbers) {
        // write code here
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int index = numbers[i];
            if (index >= n) {
                index = numbers[i] % n;
            }
            if (numbers[index] >= n) {
                return index;
            } else {
                numbers[index] += n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(array));
    }
}