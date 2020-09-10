package sort;

public class HeapSort {
    public static void main(String[] args){
        int[] nums = {4,2,6,1,3,5,6,8,9,5,6,7};
        heapSort(nums);
        for(int num :nums){
            System.out.print(num + " ");
        }
    }
    public static void heapSort(int[] nums){
        if(nums.length < 2){
            return;
        }
        //首先构造大顶堆
        for(int i = nums.length / 2 - 1; i >=0; i--){
            adjust(nums, i, nums.length);
        }

        for(int i = nums.length - 1; i > 0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            adjust(nums, 0, i);
        }
    }

    public static void adjust(int[] nums, int i, int length){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if(left < length && nums[max] <nums[left]){
            max = left;
        }
        if(right <length && nums[max] < nums[right]){
            max = right;
        }
        if(max != i){
            int temp = nums[max];
            nums[max] = nums[i];
            nums[i] = temp;
            adjust(nums, max, length);
        }
    }
}
