package sword_offer.to75;


public class Solution_53 {

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) return count;
            if (nums[i] == target) count++;
        }
        return count;

    }
}