/**
 * 类别：动态规划
 * 300、279题与这题一起看！！！
 *
 * 要点：这里要自顶向下观察，假设amount为21，硬币1，2，3，5；则画递归树时下一层就得分别减去1235，然后以此类推
 * 那么我们就可以使用动态规划的方法从amount为1开始逐个计算，
 * 对于一个amount，其最优解就是找到min（amount-coins[j]），然后再加一
 *
 *
 * ！！！动态规划就是一种特殊的递归，并且这种递归必须保证过程中对某个状态会重复计算，则使用dp记录；并且各种状态中间具有某种关系！！！
 * */
import java.util.Arrays;
public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

}
