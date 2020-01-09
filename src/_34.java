/*
* 类别：二分法
*
* 要点：首先对于二分法进行修改，分别寻找左右边界，此时要注意区间的开闭问题
* 区间开闭涉及left和right进行取值时的变化，一定要注意能否取到最后一位和第一位
*
* */
public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0)
            return result;
        result[0] = getLeftBoundary(nums, target);
        result[1] = getRightBoundary(nums, target);
        return result;
    }

    public int getLeftBoundary(int[] nums, int target){
        if(nums.length == 1)
            return (nums[0] == target) ? 0 : -1;
        int left = 0;
        int right = nums.length;
        int mid;
        while(left < right){
            mid = (right + left)/2;
            if(nums[mid] == target)
                right = mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if(left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }

    public int getRightBoundary(int[] nums, int target){
        if(nums.length == 1)
            return (nums[0] == target) ? 0 : -1;
        int left = 0;
        int right = nums.length;
        int mid;
        while(left < right){
            mid = (right + left)/2;
            if(nums[mid] == target)
                left = mid + 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if(right == 0)
            return -1;
        return (nums[right - 1] == target) ? right-1 : -1;
    }
}
