/**
 * 类别：快慢指针 双指针
 *
 * 要点：这里只需要使用快慢指针，快指针正常遍历数组，而慢指针用来指示最后一个非零数字的位置
 * 这里只需要快指针正常遍历并且把所有非零元素复制到慢指针指向的位置，0元素不需要关系
 * 快指针遍历完后，只需要从慢指针最后指向的位置开始填充0即可*/
public class _283 {
    public void moveZeroes(int[] nums) {
        int lastNotZero = 0;//慢指针
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[lastNotZero++] = nums[i];//慢指针每次被复制后便指向下一个要插入实际非零值的位置
        }
        for(int i = lastNotZero; i < nums.length; i++)
            nums[i] = 0;
    }
}
