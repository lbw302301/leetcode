/**
 * 类别：排序 哈希表
 *
 * 第二种方式，可以先对数组排序，众数一定位于 n/2的地板除的位置

 * */
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class _169 {
    //方法2
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        n /= 2;
        for (Integer key : map.keySet()) {
            if (map.get(key) > n)
                return key;
        }
        return -1;
    }
}
