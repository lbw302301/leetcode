/**
 * 类别：动态规划法
 *
 * 要点：首先计算每个点i，到达i+1时的gas-cost
 * 然后对每个点进行遍历，求得从当前点出发，保证绕一圈的过程中，dp和始终大于等于0，这个点就是符合要求的
 *
 *
 * */
public class _134 {

    private int[] dp;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        dp = new int[gas.length];
        for (int i = 0; i < gas.length; i++)
            dp[i] = gas[i] - cost[i];
        for (int i = 0; i < dp.length; i++)
            if (dp[i] >= 0 && isValid(i))
                return i;

        return -1;
    }

    private boolean isValid(int index) {
        int sum = dp[index];
        int count = 1;
        while(count < dp.length){
            if (sum + dp[(index + count)%dp.length] < 0)
                return false;
            sum += dp[(index + count)%dp.length];
            count++;
        }
        return true;
    }

}
