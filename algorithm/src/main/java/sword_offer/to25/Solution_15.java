package sword_offer.to25;


// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class Solution_15 {

    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}