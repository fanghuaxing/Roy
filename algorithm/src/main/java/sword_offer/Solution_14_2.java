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
            if (res > 1000000007) {
                res = res % 1000000007;
            }
        }
        return (int) (res * n % 1000000007);
    }

    public int cuttingRope2(int n) {
        if(n < 4) return n - 1;
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {
        //2147483647
        //1000000007
        System.out.println(Integer.MAX_VALUE);
    }

}