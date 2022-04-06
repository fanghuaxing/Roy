package sword_offer.to75;


public class Solution_57 {
    public int[] twoSum(int[] nums, int target) {
        int index_1 = 0;
        int index_2 = nums.length-1;
        int[] result = new int[2];
        while (index_1 != index_2) {
            if (nums[index_2] > target) {
                index_2--;
                continue;
            }
            if (nums[index_1] + nums[index_2] < target) {
                index_1++;
                continue;
            }
            if (nums[index_1] + nums[index_2] > target) {
                index_2--;
                continue;
            }
            if (nums[index_1] + nums[index_2] == target) {
                result[0] = nums[index_1];
                result[1] = nums[index_2];
                return result;
            }
        }
        return result;
    }

}