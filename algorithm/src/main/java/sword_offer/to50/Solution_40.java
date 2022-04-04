package sword_offer.to50;


import java.util.Arrays;

public class Solution_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}