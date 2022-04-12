package leetcode;

/**
 * @author Fang
 * @date 2022-04-12 21:33
 */
public class MaxSubMatrix {
    public int getMaxMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;
        int n = matrix.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                max = Math.max(queryCount(matrix, i, j), max);
            }
        }
        System.out.println(max);
        return max;
    }


    public int queryCount(int[][] array, int begin, int end) {
        int m = array[0].length;
        int[] temp = new int[m];
        for (int i = begin; i <= end; i++) {
            int[] arr = array[i];
            for (int j = 0; j < m; j++) {
                temp[j] += arr[j];
            }
        }
        return count(temp);
    }


    public int count(int[] array) {
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                dp = array[i];
            } else {
                dp = Math.max(dp + array[i], array[i]);
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {

//        int[][] arr = {
//                {9, -8, 1, 3, -2},
//                {-3, 7, 6, -2, 4},
//                {6, -4, -4, 8, -7}
//        };
        int[][] arr = {
                {0 ,-2, -7, 0},
                {9 , 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8,  0, -2}
        };

        new MaxSubMatrix().getMaxMatrix(arr);
    }
}
