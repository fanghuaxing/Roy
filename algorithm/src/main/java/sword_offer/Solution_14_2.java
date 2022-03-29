package sword_offer;


import java.math.BigInteger;

// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class Solution_14_2 {

    public int cuttingRope(int n) {
        if(n < 4) return n - 1;
        long res = 1;
        while(n > 4) {
            res = res * 3;
            n -=3;
            res = res % 1000000007;
        }
        return (int) (res * n % 1000000007);
    }
}