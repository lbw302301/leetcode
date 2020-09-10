/**
 * 类别：数学
 * 要点：这里数组中存放的是0-n中的连续的数字，并且缺少一个数
 * 这时候，可以计算0-n的本来的和，（0+n）* （n / 2）
 * 然后与数组的和做差就知道缺了谁
 * */
public class _268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int expectsum = nums.length * (nums.length + 1) / 2;
        for(int i = 0 ; i < nums.length; i++)
            sum += nums[i];
        return  expectsum - sum;
    }
}
