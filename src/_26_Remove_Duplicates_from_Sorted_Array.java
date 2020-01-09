/*
* 类别：双指针法
*
* 通过两个指针来实现跳过重复项的功能，只需要保证把存在过的数字保存下来即可
* */
public class _26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int i = 0 , j =1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

}
