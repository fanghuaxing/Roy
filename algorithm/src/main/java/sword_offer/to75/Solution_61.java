package sword_offer.to75;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution_61 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length!= 5) return false;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int blank = 0;
        for (int num : nums) {
            if (num == 0) {
                blank++;
            } else {
                list.add(num);
            }
        }
        if (list.size() == 0) {
            return true;
        }
        int begin = list.get(0);
        for (int i = 1; i < list.size() ; i++) {
            int num = list.get(i) - begin;
            if (num == 0) return false;
            if (num > 1) {
                blank -= (num - 1);
            }
            begin = list.get(i);
        }
        if (blank >= 0) {
            return true;
        }
        return false;
    }


    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

}