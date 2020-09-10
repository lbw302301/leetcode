/**
 * 类别：动态规划
 *
 * 要点：这里的乘法会出现乘负数以后最大变最小的情况，因此要维持两个dp，一个最大，一个最小
 * 因为此处只求最大值即可，因此dp数组只需要imax和imin两个变量代替
 * dp[i] = max/min（dp[i-1]*nums[i]，nums[i]）
 *
 * */
public class _152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
