/**
 * 类别：回溯法或者动态规划法
 *
 * 要点：回溯法中，要考虑清楚如226，则可以划分成2|26,22|6.而这两种方法的结果分别为2种和1种，则最终结果为2+1种。以此递归，直到start到最后一位
 *
 * 动态规划法中dp[i]表示从i开始的可能解码数量，且dp[i] = dp[i+1] + dp[i+2](即理解成i位置接码数可以认为是
 * 从i+1位单独解析，或者是i+1和i+2位共同解释两种情况)dp[n - 1] = 1; dp[n - 2] = 1|2，需要看s[i-1]+s[i-2]*10是否大于26
 *
 * 动态规划注意分割问题时的方向，是从后往前分还是从前往后分
 *
 */
public class _91 {
    /*方法1 回溯
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    public int getAns(String s, int start){
        if(s.length() == start)
            return 1;
        if(s.charAt(start) == '0')
            return 0;
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        if(start < s.length() - 1){
            int ten  = (s.charAt(start) - '0') * 10;
            int gewei = s.charAt(start + 1) - '0';
            if((ten + gewei) <= 26)
                ans2 = getAns(s, start + 2);
        }
        return ans1 + ans2;
    }*/
    //方法2 动态规划
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;//供给计算倒数第二个数字时使用
        if(s.charAt(len - 1) != '0')
            dp[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--){
            if(s.charAt(i) == '0')
                continue;
            //ans1表示i当前指向的单独解析，则其可能数为dp[i+1]
            int ans1 = dp[i + 1];
            int ans2 = 0;
            //ans2表示i和i+1共同指代一个解码，则可能数为dp[i+2],如果大于26证明不成立只有ans1
            int ten = (s.charAt(i) - '0') * 10;
            int gewei = s.charAt(i+1) - '0';
            if((ten + gewei) <= 26){
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
