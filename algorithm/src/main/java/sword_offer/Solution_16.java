package sword_offer;

/**
 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution_16 {

    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = 0 - n;
        }
        if (x == 1) {
            return x;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (isNegative){
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(2.1*2.1*2.1);
    }

}
