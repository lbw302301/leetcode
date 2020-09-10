/**
 * 类别：动态规划
 * 要点：dp表示从前i个房子中可以获得的最大收益
 *      dp[i] = max(dp[i-2]+nums[i] ， dp[i-1])
 * */
public class _198 {
    public int rob(int[] nums) {
        int cur = 0;
        int pre = 0;
        for(int i : nums){
            int temp = cur;//cur表示dp【i-1】
            cur = Math.max(pre + i, cur);//这里计算左边的cur表示dp【i】，而右边的cur表示dp【i-1】
            pre = temp;//pre表示dp【i-2】
        }
        return cur;
    }
}
