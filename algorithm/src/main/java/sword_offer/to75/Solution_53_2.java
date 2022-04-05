package sword_offer.to75;


public class Solution_53_2 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i]-1;
            }

        }
        return nums[nums.length-1]+1;
    }

}