package sword_offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution_21 {
    public int[] exchange(int[] nums) {
        int index1 = 0;
        int index2 = nums.length-1;
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) { //奇数
                array[index1++] = nums[i];
            } else {
                array[index2--] = nums[i];
            }
        }
        return array;
    }

}
