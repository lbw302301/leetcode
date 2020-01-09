/**
 * 类别： 动态规划
 * 思路：由于题目结果要求计算从左上角开始到达右下角点的可能路径数量，因此使用dp保存到每个点的路径数量
 *  因为可选择的动作只有向右和向下，则对于一个点来说，可能的上一个点只能是左边或者上边
 *            {dp[i][j-1], i=0,j!=0,即位于上边时
 *  dp[i][j]= dp[i-1][j] + dp[i-1][j];
 *             1,i=0,j=0
 *             dp[i-1][0],j = 0. i!=0,即位于左边时}
 *
 * ！！动态规划的主要思路就是计算一个推导方程式，计算由上一个状态可能到达的下一个状态的表达式。这个状态就跟题目的解密切相关，
 * 状态可以从最终状态倒推也可以正推
 *
 *
 *
 * */
public class _62 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i = 0 ;i < m; i++)
            res[i][0] = 1;
        for(int j = 0; j < n; j++)
            res[0][j] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m-1][n-1];
    }
}
