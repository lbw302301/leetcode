/**
 * 类别：哈希表
 *
 * 要点：一种方法可以排序，相同的两个肯定挨着，判断nums【i】==nums【i+1】即可
 *      一种方法可以使用set，set中不能存在重复元素*/
import java.util.HashSet;
import java.util.Set;

public class _217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            set.add(nums[i]);
        }
        if(nums.length > set.size())
            return true;
        return false;
    }
}
