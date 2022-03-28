package sword_offer;


import java.util.HashMap;
import java.util.Stack;

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class Solution_10_2 {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = (numWays(n - 1) + numWays(n - 2) )% 1000000007;
        cache.put(n, result);
        return result;
    }
}