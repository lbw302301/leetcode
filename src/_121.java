/**
 * 类别：动态规划法
 *
 * 要点：dp[i]表示当天卖出可能获得最大利润
 * dp[0] = 负无穷
 * dp[1] = p[1] - p[0];
 * dp[i] = max(dp[i-1]+p[i]-p[i-1] , p[i]-p[i-1])
 *
 * */
import java.util.Arrays;

public class _121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1)
            return 0;
        int[] dp = new int[length];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = prices[1] - prices[0];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max((dp[i - 1] + (prices[i] - prices[i - 1])), (prices[i] - prices[i - 1]));
        }
        Arrays.sort(dp);
        return (dp[length - 1] > 0) ? dp[length - 1] : 0;
    }
}
