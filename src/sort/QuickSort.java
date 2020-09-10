package sort;

public class QuickSort {
    public static void main(String[] args){
        int[] nums = {4,2,6,1,3,5,6,8,9,5,6,7};
        quickSort(nums, 0, nums.length - 1);
        for(int num :nums){
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left <= right){
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right){
        int key = right;
        while(left <right){
            while(left < right && nums[left] <= nums[key]){
                left++;
            }
            while(left <right && nums[right] >= nums[key]){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[left];
        nums[left] = nums[key];
        nums[key] = temp;
        return left;
    }
}
