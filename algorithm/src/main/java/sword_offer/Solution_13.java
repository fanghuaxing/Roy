package sword_offer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
// 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外） ,
// 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
// 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
public class Solution_13 {

    public int movingCount(int m, int n, int k) {
        int[][] cache = new int[m][n];
        return moving(0, 0, m, n, k,cache);
    }

    public int moving(int x, int y, int m, int n, int k, int[][] cache) {
        int result = 0;
        while (access(x, y, m, n, k,cache)) {
            cache[x][y] = 1;
//            int top = moving(x-1, y, m, n, k,cache);  // redundant
            int bottom = moving(x+1, y, m, n, k,cache);
//            int left = moving(x, y-1, m, n, k,cache);  // redundant
            int right = moving(x, y+1, m, n, k,cache);
//            result = top + bottom + left + right +1;
            result =  bottom  + right +1;
        }
        return result;
    }

    private boolean access(int x, int y, int m, int n, int k,int[][] cache) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (cache[x][y] == 1){
            return false;
        }
        return (countNum(x) + countNum(y)) <= k;
    }

    private int countNum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        return result;
    }

    // 16 8   // 4
    public static void main(String[] args) {
        System.out.println(new Solution_13().movingCount(16, 8, 4));
    }
}