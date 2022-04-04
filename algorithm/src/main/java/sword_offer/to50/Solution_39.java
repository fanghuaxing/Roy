package sword_offer.to50;


import java.util.HashMap;

public class Solution_39 {
    public int majorityElement(int[] nums) {
        int limit = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer count = hashMap.getOrDefault(num, 0);
            if (count >= limit) {
                return num;
            }
            hashMap.put(num, ++count);
        }
        return -1;
    }

}