package sword_offer.to25;


// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
//
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
public class Solution_14_1 {
    // 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
    // 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1 + 1 。
    // 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2 X 2 > 3 X 1
    public int cuttingRope(int n) {
        if (n == 2 ) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
         return  maxCut(n, 3)  ;
    }

    private int maxCut(int remain, int cut) {
        if (remain <= 0) {
            return 1;
        }
        if (remain == 1) {
            return 1;
        }
        if (remain == 2) {
            return 2;
        }
        if (remain == 3) {
            return 3;
        }
        if (remain == 4) {
            return 4;
        }
        if (remain == 5) {
            return 6;
        }
        return cut * maxCut(remain - cut, cut);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_14_1().cuttingRope(10));
    }

    //我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
    //用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
    //我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
    //剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
    //第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
    //dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
    //最后返回dp[n]即可
    public double cuttingRope2(int n) {
        double[] dp = new double[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                double cutting = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], cutting);
            }
        }
        return dp[n];
    }

    public int cuttingRope3(int n) {
        if(n < 4) return n - 1;
        int result = 1;
        while(n > 4) {
            result *= 3;
            n -=3;
        }
        return result * n  % 1000000007;
    }

}