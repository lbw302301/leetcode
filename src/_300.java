/**
 * 类别：动态规划
 *
 * 要点：这里dp表示，在i之前，小于NUMS[i]的有多少个（并且加1），由于上升串最短为1，所以dp[0]为1
 * 而dp[i]的计算，则需要比较i与0 -- i-1的所有数字，如果i大，则计算出一个dp[i]，并且从这些结果选择一个最大值当作最终结果
 * */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ansmax = 1;
        for(int i = 1; i < nums.length; i++){
            int maxval = 0;//这个表示dp【j】的最大值
            for(int j = 0; j < i; j++){
                //对0 -- i-1 遍历，寻找所有nums【i】大于nums【j】的dp【j】的最大值
                if(nums[i] > nums[j])
                    maxval = Math.max(maxval, dp[j]);
            }
            dp[i] = maxval + 1;
            ansmax = Math.max(dp[i],ansmax);
        }
        return ansmax;
    }
}
