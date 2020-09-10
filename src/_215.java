/**
 * 类别：数组 排序
 *
 * comparator只能适用于对象数组*/
import java.util.Arrays;

public class _215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
