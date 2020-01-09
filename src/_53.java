/*
* 类别：动态规划法
*
* 思路:按照顺序从第一位开始，寻找以当前位作为末尾的子串的和，当指向i时，sum表示以i-1为结尾的最大和
* 如果sum<0，说明对增大最后的结果没意义则舍弃掉，最后结果则取i对应的sum和之前ans的最大值
*
* ！！！动态规划即把大问题拆解成一个个的小问题的最优解，然后从最优解开始逐步扩展
*
* */
public class _53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int sum = 0;
        int ans = nums[0];
        for(int num : nums){
            if(sum >= 0)
                sum = sum + num;
            else
                sum = num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
