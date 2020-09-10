package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,4,5,6,45,456,2,5,0};
        bubbleSort(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
