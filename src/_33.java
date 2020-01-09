/*
* 类别：二分法
* 时间复杂度O(logn)的排序算法典型就是二分法
* 这里要考虑对二分法进行变形，因为不一定严格按照顺序排列
*
* 当在判断时，先判断是否为有序序列，同时要充分考虑只有两个元素特殊情况
*
* */
public class _33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else{
                if(target >= nums[left] || target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

}
