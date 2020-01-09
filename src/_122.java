/**
 * 股票买卖策略：
 *
 * 单独交易日： 设今天价格 p_1明天价格 p_2则今天买入、明天卖出可赚取金额 p_2 - p_1（负值代表亏损）。
 * 连续上涨交易日： 设此上涨交易日股票价格分别为 p_1, p_2, ... , p_n
 * 则第一天买最后一天卖收益最大，即 p_n - p_1；等价于每天都买卖，即 p_n - p_1=(p_2 - p_1)+(p_3 - p_2)+...+(p_n - p_{n-1})p
 * n−p1=(p2−p
 * 1)+(p3−p2)+...+(pn−pn−1)。
 * 连续下降交易日： 则不买卖收益最大，即不会亏钱。
 * 算法流程：
 *
 * 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
 * 设 tmp 为第 i-1 日买入与第 i 日卖出赚取的利润，即 tmp = prices[i] - prices[i - 1] ；
 * 当该天利润为正 tmp > 0，则将利润加入总利润 profit；当利润为 00 或为负，则直接跳过；
 * 遍历完成后，返回总利润 profit。
 *
 * */
public class _122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int dif = prices[i] - prices[i - 1];
            if(dif > 0)
                profit += dif;
        }
        return profit;
    }
}
