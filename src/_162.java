/**
 * 类别：二分法
 *
 * 要点：二分法的时间复杂度O（logn）
 *
 * 峰值只可能出现在较大的一侧
 *
 * */
public class _162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
