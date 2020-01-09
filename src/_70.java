/**
 * 类别： 动态规划
 *
 * 要点：动态规划即要通过将问题拆解成显然可见的问题，然后再通过此解一直类推，知道将所有状态的结果都保存下来
 *
 * */
public class _70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
