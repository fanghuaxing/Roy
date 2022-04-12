package leetcode;

/**
 * @author Fang
 * @date 2022-04-12 21:33
 */
public class MaxSubMatrix2 {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];//保存最大子矩阵的左上角和右下角的行列坐标
        int n = matrix.length;
        int m = matrix[0].length;
        //记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int dp = 0;//相当于dp[i],dp_i
        int maxSum = Integer.MIN_VALUE;//记录最大值
        int x1 = 0;
        int y1 = 0; //暂时记录左上角，相当于begin

        for (int i = 0; i < n; i++) {     //以i为上边，从上而下扫描
            int[] temp = new int[m];
            for (int j = i; j < n; j++) {    //子矩阵的下边，从i到N-1，不断增加子矩阵的高
                //一下就相当于求一次最大子序列和
                dp = 0;//从头开始求dp
                for (int k = 0; k < m; k++) {
                    temp[k] += matrix[j][k];
                    //我们只是不断增加其高，也就是下移矩阵下边，所有这个矩阵每列的和只需要加上新加的哪一行的元素
                    //因为我们求dp[i]的时候只需要dp[i-1]和nums[i],所有在我们不断更新b数组时就可以求出当前位置的dp_i
                    if (dp > 0) {
                        dp += temp[k];
                    } else {
                        dp = temp[k];
                        x1 = i; // 暂时保存其左上角
                        y1 = k;
                    }
                    if (dp > maxSum) {
                        maxSum = dp;
                        ans[0] = x1;//更新答案
                        ans[1] = y1;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }
}
