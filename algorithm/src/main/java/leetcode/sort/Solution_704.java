package leetcode.sort;

public class Solution_704 {
    public int search(int[] nums, int target) {
        return  searchForBinary(nums, 0, nums.length - 1, target);
    }

    public int searchForBinary(int[] nums, int start, int end, int target) {
        int midIndex = (start + end) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (start == end) {
            return -1;
        }
        if (nums[midIndex] > target) {
            return searchForBinary(nums, start, midIndex, target);
        } else {
            return searchForBinary(nums, midIndex+1, end, target);
        }
    }
}