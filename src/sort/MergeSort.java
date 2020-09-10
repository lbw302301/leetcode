package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 1, 3, 5, 6, 8, 9, 5, 6, 7};
        int[] res = mergeSort(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int length = left.length + right.length;
        int[] res = new int[length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            res[i++] = left[l] < right[r] ? left[l++] : right[r++];
        }
        while (l < left.length) {
            res[i++] = left[l++];
        }
        while (r < right.length) {
            res[i++] = right[r++];
        }
        return res;
    }
}
